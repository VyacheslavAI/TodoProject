package ru.ivanov.studyproject.dao;

import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

//Problems:
//1 clone persistent object
//Rename all
//Document class
//Refactor exceptions
//Remove null return from dao
//Add generic for dataSource from dao
//Make dataSource instance in dao final
//Date created and deadline set hour minute seconds to zero
//Refactor method "getByDate" to before date --- after date
//Refactor cast to single object from list from dao
//Try to fix IDEA warnings
//All selectSection starts with 0(zero number)
//Only controller for all
//Refactor works with entities in service or model by generics (like hibernate)
//Add full information in list object(created, deadline etc
//Use generics or Object class for selectProject (selectTask)
//Refactor  plural or singular variable names
//Extended base entity for except reflection
//Refactor fullName for Assignees
//Refactor name for Teamlead
//Refactor name for Client
//Refactor loadClientForMainObject

public class DataSource<E> {

    private static DataSource dataSource = new DataSource();

    private final Map<String, Map<String, PersistentEntity>> repository = new HashMap<>();

    private final List<String> sequence = new ArrayList<>();

    private final Map<String, Set<String>> relationshipRatio = new HashMap<>();

    public static DataSource getDataSource() {
        return dataSource;
    }

    private DataSource() {
    }

    //May be deleted. Refactor
    public List<String> getRelationships(Class<E> eClass) {
        return new ArrayList<>(relationshipRatio.get(eClass.getSimpleName()));
    }

    private List<PersistentEntity> getPersistentEntitiesListForClass(Class<E> eClass) {
        return new ArrayList<>(repository.get(eClass.getSimpleName()).values());
    }

    public List<E> getAllEntityObjects(Class<E> eClass) {
        List<E> entityObjects = new ArrayList<>();
        List<PersistentEntity> persistentEntities = getPersistentEntitiesListForClass(eClass);

        for (PersistentEntity persistentEntity : persistentEntities) {
            entityObjects.add(persistentEntity.getEntity());
        }

        return entityObjects;
    }

    public List<E> searchEntitiesByRelations(List relationList, Class<E> persistentClass) throws NoSuchFieldException, IllegalAccessException {
        List<PersistentEntity> persistentEntities = getPersistentEntitiesListForClass(persistentClass);
        List<E> result = new ArrayList<>();

        if (persistentEntities.isEmpty())
            return result;

        String persistentEntityType = persistentClass.getSimpleName();

        for (Object relation : relationList) {
            String relationEntityType = relation.getClass().getSimpleName();

            if (!relationshipRatio.get(persistentEntityType).contains(relationEntityType))
                continue;

            String relationId = relation.getClass().getField("id").get(relation).toString();

            for (PersistentEntity persistentEntity : persistentEntities) {
                List relations = persistentEntity.getRelations().get(relationEntityType);
                for (Object entityRelation : relations) {
                    String entityRelationId = entityRelation.getClass().getField("id").get(entityRelation).toString();
                    if (entityRelationId.equals(relationId))
                        result.add(persistentEntity.getEntity());
                }
            }
        }

        return result;
    }

    public E createOrUpdateEntity(E entity) throws ObjectIsNotPersistentException {
        try {
            String id = entity.getClass().getMethod("getId").invoke(entity).toString();
            String className = entity.getClass().getSimpleName();

            if ("0".equals(id))
                createNewEntity(entity, className);
            else
                updateEntity(id, entity, className);

            return entity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
            throw new ObjectIsNotPersistentException("Object is not persistent");
        }

    }

    public void createNewEntity(E entity, String className) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!repository.containsKey(className)) {
            repository.put(className, new HashMap<String, PersistentEntity>());
        }

        Map<String, PersistentEntity> entityRepository = repository.get(className);

        String id = UUID.randomUUID().toString();

        while (sequence.contains(id)) {
            id = UUID.randomUUID().toString();
        }
        sequence.add(id);

        Method setId = entity.getClass().getMethod("setId", String.class);
        setId.invoke(entity, id);

        PersistentEntity persistentEntity = new PersistentEntity(entity);
        entityRepository.put(id, persistentEntity);
    }

    public void updateEntity(String id, E entity, String className) {
        PersistentEntity persistentEntity = repository.get(className).get(id);
        persistentEntity.setEntity(entity);
    }

    public void updateRelation(List<List> entities) throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < entities.size(); i++) {
            List main = entities.get(i);

            for (int j = 0; j < entities.size(); j++) {
                if (j != i) {
                    List other = entities.get(j);

                    String mainType = main.get(0).getClass().getSimpleName();
                    String otherType = other.get(0).getClass().getSimpleName();

                    if (relationshipRatio.get(mainType).contains(otherType)) {
                        for (Object mainObj : main) {
                            String mainId = mainObj.getClass().getField("id").get(mainObj).toString();

                            PersistentEntity mainP = repository.get(mainType).get(mainId);
                            for (Object anOther : other) {
                                mainP.putRelation(anOther);
                            }
                        }
                    }
                }
            }
        }
    }

    private class PersistentEntity {
        private E entity;
        private final Map<String, List> relations;

        public PersistentEntity(E entity) {
            this.entity = entity;
            relations = new HashMap<>();

            Field[] fields = entity.getClass().getFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];

                if (field.getType() == List.class) {
                    String typeName = field.getGenericType().getTypeName();
                    Set<String> linkNames = relationshipRatio.putIfAbsent(entity.getClass().getSimpleName(), new HashSet<>());
                    linkNames.add(typeName);
                    relations.put(typeName, new ArrayList<>());
                }
            }
        }

        E getEntity() {
            return entity;
        }

        void setEntity(E entity) {
            this.entity = entity;
        }

        public Map<String, List> getRelations() {
            return relations;
        }

        public void putRelation(Object relation) {
            relations.get(relation.getClass().getSimpleName()).add(relation);
        }

        public void removeRelation(Object relation) {
            relations.get(relation.getClass().getSimpleName()).remove(relation);
        }
    }
}