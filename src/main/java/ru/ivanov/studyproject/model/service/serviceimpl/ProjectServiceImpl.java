package ru.ivanov.studyproject.model.service.serviceimpl;

import ru.ivanov.studyproject.dao.interfaces.ProjectDA;
import ru.ivanov.studyproject.dao.memoryImpl.ProjectDAO;
import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;
import ru.ivanov.studyproject.model.service.serviceinterfaces.ProjectService;

import java.util.Date;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectDA projectDA = new ProjectDAO();

    @Override
    public Project createOrUpdateProject(String id, String name, String description, Date created, Date deadline) throws ObjectIsNotPersistentException {
        Project project = new Project(id, name, description, created, deadline);
        return projectDA.createOrUpdateProject(project);
    }

    @Override
    public List<Project> getProjectsByClient(Client client) {
        return projectDA.getProjectsByClient(client);
    }

    @Override
    public List<Project> getProjectsByCreated(Date created) {
        return projectDA.getProjectsByCreated(created);
    }

    @Override
    public List<Project> getProjectsByDeadline(Date deadline) {
        return projectDA.getProjectsByDeadline(deadline);
    }

    @Override
    public Project getProjectByTask(Task task) {
        return projectDA.getProjectByTask(task);
    }

    @Override
    public List<Project> getProjectsByAssignee(Assignee assignee) {
        return projectDA.getProjectsByAssignee(assignee);
    }

    @Override
    public List<Project> getProjectsByTeamlead(Teamlead teamlead) {
        return projectDA.getProjectsByTeamlead(teamlead);
    }

    @Override
    public List<String> getRelationNames() {
        return projectDA.getRelationNames();
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDA.getAllProjects();
    }
}
