package ru.ivanov.studyproject.model.service.serviceinterfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.List;

public interface TeamleadService {

    Teamlead getTeamleadByPosition(String position);

    Teamlead getTeamleadByAssignee(Assignee assignee);

    Teamlead getTeamleadByProject(Project project);

    Teamlead createOrUpdateTeamlead(String id, String position) throws ObjectIsNotPersistentException;

    List<String> getRelationNames();

    List<Teamlead> getAllTeamleads();
}
