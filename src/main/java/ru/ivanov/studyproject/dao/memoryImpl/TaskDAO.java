package ru.ivanov.studyproject.dao.memoryImpl;

import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.dao.interfaces.TaskDA;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TaskDAO implements TaskDA {

    private final DataSource dataSource = DataSource.getDataSource();

    @Override
    public Task createOrUpdateTask(Task task) throws ObjectIsNotPersistentException {
        return (Task) dataSource.createOrUpdateEntity(task);
    }

    @Override
    public List<Task> getTasksByProject(Project project) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(project), Task.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Task> getTaskByCreated(Date created) {
        List<Task> tasks = dataSource.getAllEntityObjects(Task.class);
        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getCreated().equals(created)) {
                result.add(task);
            }
        }

        return result;
    }

    @Override
    public List<Task> getTasksByDeadline(Date deadline) {
        List<Task> tasks = dataSource.getAllEntityObjects(Task.class);
        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getDeadline().equals(deadline)) {
                result.add(task);
            }
        }

        return result;
    }

    @Override
    public List<Task> getTasksByAssignee(Assignee assignee) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(assignee), Assignee.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<String> getRelationNames() {
        return dataSource.getRelationships(Task.class);
    }

    @Override
    public List<Task> getAllTasks() {
        return dataSource.getAllEntityObjects(Task.class);
    }
}
