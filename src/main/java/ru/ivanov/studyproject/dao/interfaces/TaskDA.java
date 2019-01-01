package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;

import java.util.Date;
import java.util.List;

public interface TaskDA {

    List<Task> getTasksByProject(Project project);

    List<Task> getTaskByCreated(Date created);

    List<Task> getTasksByDeadline(Date deadline);

    List<Task> getTasksByAssignee(Assignee assignee);

    List<Task> getAllTasks();
}
