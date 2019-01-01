package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;

import java.util.Date;
import java.util.List;

public interface TaskDA {

    Task getTaskById(String id);

    Task getTaskByProject(Project project);

    Task getTaskByCreated(Date created);

    Task getTaskByDeadline(Date deadline);

    Task getTaskByAssignee(Assignee assignee);

    Task getTaskByAssignees(List<Assignee> assigneeList);
}
