package ru.ivanov.studyproject.dao;

import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

//Problems:
//1 clone persistent object

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

    public E createOrUpdateEntity(E entity) throws ObjectIsNotPersistentException {
        try {
            String id = new String(entity.getClass().getField("id").get(entity).toString());
            String className = entity.getClass().getSimpleName();

            if ("0".equals(id))
                createNewEntity(entity, className);
            else
                updateEntity(id, entity, className);

            return entity;
        } catch (Exception e) {
            throw new ObjectIsNotPersistentException("Object is not persistent");
        }
    }

    public void createNewEntity(E entity, String className) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean entityRepositoryExists = repository.containsKey(className);

        if (!entityRepositoryExists) {
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

    public void updateEntity(String id, E entity, String className) throws NoSuchFieldException {
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

//    public E cloneEntity(E entity) {
//
//    }

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
                    relations.put(field.getGenericType().getTypeName(), new ArrayList<>());
                }
            }
        }

        E getEntity() {
            return entity;
        }

        void setEntity(E entity) {
            this.entity = entity;
        }

        public void putRelation(Object relation) {
            relations.get(relation.getClass().getSimpleName()).add(relation);
        }

        public void removeRelation(Object relation) {
            relations.get(relation.getClass().getSimpleName()).remove(relation);
        }
    }
}