package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;

import java.util.Date;
import java.util.List;

public interface ProjectDA {

    Project getProjectById(String id);

    List<Project> getProjectsByClient(Client client);

    List<Project> getProjectsByCreated(Date created);

    List<Project> getProjectsByDeadline(Date deadline);

    Project getProjectByTask(Task task);

    List<Project> getProjectsByAssignee(Assignee assignee);
}
