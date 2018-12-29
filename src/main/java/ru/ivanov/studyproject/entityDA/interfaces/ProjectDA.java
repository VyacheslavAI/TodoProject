package ru.ivanov.studyproject.entityDA.interfaces;

import ru.ivanov.studyproject.entities.*;

import java.util.Date;

public interface ProjectDA {

    Project getProjectById(String id);

    Project getProjectByClient(Client client);

    Project getProjectByResponsiblePerson(ResponsiblePerson person);

    Project getProjectByCreated(Date created);

    Project getProjectByDeadline(Date deadline);

    Project getProjectByTask(Task task);

    Project getProjectByAssignee(Assignee assignee);
}
