package ru.ivanov.studyproject.model.service.serviceinterfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.Date;
import java.util.List;

public interface TaskService {

    List<Task> getTasksByProject(Project project);

    List<Task> getTaskByCreated(Date created);

    List<Task> getTasksByDeadline(Date deadline);

    List<Task> getTasksByAssignee(Assignee assignee);

    Task createOrUpdateTask(String id, String name, String description, Date created, Date deadline) throws ObjectIsNotPersistentException;

    List<String> getRelationNames();

    List<Task> getAllTasks();
}
