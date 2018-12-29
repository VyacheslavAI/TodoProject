package ru.ivanov.studyproject.entityDA.entityMemoryMapDAO;

import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.ResponsiblePerson;
import ru.ivanov.studyproject.entityDA.interfacesDA.ResponsiblePersonDA;
import ru.ivanov.studyproject.entityRelation.ResponsiblePersonRO;
import ru.ivanov.studyproject.repositories.MemoryMapRepo;

import java.util.Map;
import java.util.Set;

public class ResponsiblePersonMemoryMapDAO implements ResponsiblePersonDA {

    @Override
    public ResponsiblePerson getResponsiblePersonByProject(Project project) {
        Map<ResponsiblePerson, ResponsiblePersonRO> personMap = MemoryMapRepo.PERSON_MAP;
        for (Map.Entry<ResponsiblePerson, ResponsiblePersonRO> pair : personMap.entrySet()) {
            ResponsiblePerson person = pair.getKey();
            ResponsiblePersonRO personRO = pair.getValue();
            if (personRO.getProjects().contains(project))
                return person;
        }
        return null;
    }

    @Override
    public ResponsiblePerson getResponsiblePersonByPosition(String position) {
        Set<ResponsiblePerson> personSet = MemoryMapRepo.PERSON_MAP.keySet();
        for (ResponsiblePerson person : personSet)
            if (person.getPosition().equals(position))
                return person;
        return null;
    }
}
