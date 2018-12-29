package ru.ivanov.studyproject.entityDA.interfacesDA;

import ru.ivanov.studyproject.entities.*;

import java.util.Date;
import java.util.List;

public interface ProjectDA {

    Project getProjectById(String id);

    List<Project> getProjectsByClient(Client client);

    List<Project> getProjectsByResponsiblePerson(ResponsiblePerson person);

    List<Project> getProjectsByCreated(Date created);

    List<Project> getProjectsByDeadline(Date deadline);

    Project getProjectByTask(Task task);

    List<Project> getProjectsByAssignee(Assignee assignee);
}
