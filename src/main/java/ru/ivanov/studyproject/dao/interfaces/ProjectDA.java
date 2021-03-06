package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.Date;
import java.util.List;

public interface ProjectDA {

    Project getProjectByTask(Task task);

    Project createOrUpdateProject(Project project) throws ObjectIsNotPersistentException;

    List<Project> getProjectsByClient(Client client);

    List<Project> getProjectsByCreated(Date created);

    List<Project> getProjectsByDeadline(Date deadline);

    List<Project> getProjectsByAssignee(Assignee assignee);

    List<Project> getProjectsByTeamlead(Teamlead teamlead);

    List<String> getRelationNames();

    List<Project> getAllProjects();
}
