package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.Date;
import java.util.List;

public interface TaskDA {

    Task createOrUpdateTask(Task task) throws ObjectIsNotPersistentException;

    List<Task> getTasksByProject(Project project);

    List<Task> getTaskByCreated(Date created);

    List<Task> getTasksByDeadline(Date deadline);

    List<Task> getTasksByAssignee(Assignee assignee);

    List<String> getRelationNames();

    List<Task> getAllTasks();
}
