package ru.ivanov.studyproject.entityDA.entityMemoryMapDAO;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.entityDA.interfacesDA.ProjectDA;
import ru.ivanov.studyproject.entityRelation.ProjectRO;
import ru.ivanov.studyproject.repositories.MemoryMapRepo;

import java.util.*;

public class ProjectMemoryMapDAO implements ProjectDA {

    @Override
    public Project getProjectById(String id) {
        Map<Project, ProjectRO> projectMap = MemoryMapRepo.PROJECT_MAP;
        Set<Project> projects = projectMap.keySet();
        for (Project project : projects)
            if (project.getId().equals(id))
                return project;
        return null;
    }

    @Override
    public List<Project> getProjectsByClient(Client client) {
        Map<Project, ProjectRO> projectMap = MemoryMapRepo.PROJECT_MAP;
        List<Project> projects = new ArrayList<>();
        for (Map.Entry<Project, ProjectRO> pair : projectMap.entrySet()) {
            Project project = pair.getKey();
            ProjectRO projectRO = pair.getValue();
            Client projectClient = projectRO.getClient();
            if (projectClient.getId().equals(client.getId()))
                projects.add(project);
        }
        return projects;
    }

    @Override
    public List<Project> getProjectsByResponsiblePerson(ResponsiblePerson person) {
        Map<Project, ProjectRO> projectMap = MemoryMapRepo.PROJECT_MAP;
        List<Project> projects = new ArrayList<>();
        for (Map.Entry<Project, ProjectRO> pair : projectMap.entrySet()) {
            Project project = pair.getKey();
            ProjectRO projectRO = pair.getValue();
            ResponsiblePerson personProject = projectRO.getResponsiblePerson();
            if (personProject.getId().equals(person.getId()))
                projects.add(project);
        }
        return projects;
    }

    @Override
    public List<Project> getProjectsByCreated(Date created) {
        List<Project> projects = new ArrayList<>(MemoryMapRepo.PROJECT_MAP.keySet());
        for (Project project : projects)
            if (project.getCreated().equals(created))
                projects.add(project);
        return projects;
    }

    @Override
    public List<Project> getProjectsByDeadline(Date deadline) {
        List<Project> projects = new ArrayList<>(MemoryMapRepo.PROJECT_MAP.keySet());
        for (Project project : projects)
            if (project.getDeadline().equals(deadline))
                projects.add(project);
        return projects;
    }

    @Override
    public Project getProjectByTask(Task task) {
        Map<Project, ProjectRO> projectMap = MemoryMapRepo.PROJECT_MAP;
        for (Map.Entry<Project, ProjectRO> pair : projectMap.entrySet()) {
            Project project = pair.getKey();
            ProjectRO projectRO = pair.getValue();
            if (projectRO.getTasks().contains(task))
                return project;
        }
        return null;
    }

    @Override
    public List<Project> getProjectsByAssignee(Assignee assignee) {
        Map<Project, ProjectRO> projectMap = MemoryMapRepo.PROJECT_MAP;
        List<Project> projects = new ArrayList<>();
        for (Map.Entry<Project, ProjectRO> pair : projectMap.entrySet()) {
            Project project = pair.getKey();
            ProjectRO projectRO = pair.getValue();
            List<Assignee> assigneesProject = projectRO.getAssignees();
            if (assigneesProject.contains(assignee))
                projects.add(project);
        }
        return projects;
    }
}
