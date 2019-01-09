package ru.ivanov.studyproject.model.service;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.model.service.serviceimpl.ProjectServiceImpl;
import ru.ivanov.studyproject.model.service.serviceinterfaces.ProjectService;

import java.util.List;

public class ProjectModel {

    private final ProjectService projectService = new ProjectServiceImpl();

    public List<Project> loadAllProjects() {
        return projectService.getAllProjects();
    }

    public List<Assignee> loadAssigneesForProject() {
        return null;
    }

    public List<Client> loadClientForProject() {
        return null;

    }

    public List<Task> loadTasksForProject() {
        return null;

    }

    public List<Teamlead> loadTeamleadForProject() {
        return null;

    }
}
