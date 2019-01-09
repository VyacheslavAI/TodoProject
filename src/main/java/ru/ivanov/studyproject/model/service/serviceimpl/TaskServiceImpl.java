package ru.ivanov.studyproject.model.service.serviceimpl;

import ru.ivanov.studyproject.dao.interfaces.TaskDA;
import ru.ivanov.studyproject.dao.memoryImpl.TaskDAO;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;
import ru.ivanov.studyproject.model.service.serviceinterfaces.TaskService;

import java.util.Date;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskDA taskDA = new TaskDAO();

    @Override
    public Task createOrUpdateTask(String id, String name, String description, Date created, Date deadline) throws ObjectIsNotPersistentException {
        Task task = new Task(id, name, description, created, deadline);
        return taskDA.createOrUpdateTask(task);
    }

    @Override
    public List<Task> getTasksByProject(Project project) {
        return taskDA.getTasksByProject(project);
    }

    @Override
    public List<Task> getTaskByCreated(Date created) {
        return taskDA.getTaskByCreated(created);
    }

    @Override
    public List<Task> getTasksByDeadline(Date deadline) {
        return taskDA.getTasksByDeadline(deadline);
    }

    @Override
    public List<Task> getTasksByAssignee(Assignee assignee) {
        return taskDA.getTasksByAssignee(assignee);
    }

    @Override
    public List<String> getRelationNames() {
        return taskDA.getRelationNames();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDA.getAllTasks();
    }
}
