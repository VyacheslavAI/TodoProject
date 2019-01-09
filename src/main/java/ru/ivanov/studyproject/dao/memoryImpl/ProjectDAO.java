package ru.ivanov.studyproject.dao.memoryImpl;

import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.dao.interfaces.ProjectDA;
import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProjectDAO implements ProjectDA {

    private final DataSource dataSource = DataSource.getDataSource();

    @Override
    public List<Project> getProjectsByClient(Client client) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(client), Project.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Project> getProjectsByCreated(Date created) {
        List<Project> projects = dataSource.getAllEntityObjects(Project.class);
        List<Project> result = new ArrayList<>();

        for (Project project : projects) {
            if (project.getCreated().equals(created)) {
                result.add(project);
            }
        }

        return result;
    }

    @Override
    public List<Project> getProjectsByDeadline(Date deadline) {
        List<Project> projects = dataSource.getAllEntityObjects(Project.class);
        List<Project> result = new ArrayList<>();

        for (Project project : projects) {
            if (project.getDeadline().equals(deadline)) {
                result.add(project);
            }
        }

        return result;
    }

    @Override
    public Project getProjectByTask(Task task) {
        try {
            return (Project) dataSource.searchEntitiesByRelations(Arrays.asList(task), Task.class).get(0);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Project> getProjectsByAssignee(Assignee assignee) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(assignee), Project.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Project> getProjectsByTeamlead(Teamlead teamlead) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(teamlead), Teamlead.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Project createOrUpdateProject(Project project) throws ObjectIsNotPersistentException {
        return (Project) dataSource.createOrUpdateEntity(project);
    }

    @Override
    public List<String> getRelationNames() {
        return dataSource.getRelationships(Project.class);
    }

    @Override
    public List<Project> getAllProjects() {
        return dataSource.getAllEntityObjects(Project.class);
    }
}
