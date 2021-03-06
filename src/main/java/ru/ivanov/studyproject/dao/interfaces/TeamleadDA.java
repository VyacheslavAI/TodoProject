package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.List;

public interface TeamleadDA {

    Teamlead getTeamleadByPosition(String position);

    Teamlead getTeamleadByAssignee(Assignee assignee);

    Teamlead getTeamleadByProject(Project project);

    Teamlead createOrUpdateTeamlead(Teamlead teamlead) throws ObjectIsNotPersistentException;

    List<String> getRelationNames();

    List<Teamlead> getAllTeamleads();
}
