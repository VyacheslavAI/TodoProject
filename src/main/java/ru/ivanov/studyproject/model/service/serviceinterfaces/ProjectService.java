package ru.ivanov.studyproject.model.service.serviceinterfaces;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.Date;
import java.util.List;

public interface ProjectService {

    List<Project> getProjectsByClient(Client client);

    List<Project> getProjectsByCreated(Date created);

    List<Project> getProjectsByDeadline(Date deadline);

    Project getProjectByTask(Task task);

    List<Project> getProjectsByAssignee(Assignee assignee);

    List<Project> getProjectsByTeamlead(Teamlead teamlead);

    Project createOrUpdateProject(String id, String name, String description, Date created, Date deadline) throws ObjectIsNotPersistentException;

    List<String> getRelationNames();

    List<Project> getAllProjects();
}
