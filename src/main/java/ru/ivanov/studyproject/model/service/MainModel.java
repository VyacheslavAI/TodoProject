package ru.ivanov.studyproject.model.service;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;
import ru.ivanov.studyproject.model.service.serviceimpl.*;
import ru.ivanov.studyproject.model.service.serviceinterfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();

    private final ProjectService projectService = new ProjectServiceImpl();

    private final TaskService taskService = new TaskServiceImpl();

    private final AssigneeService assigneeService = new AssigneeServiceImpl();

    private final ClientService clientService = new ClientServiceImpl();

    private final TeamleadService teamleadService = new TeamleadServiceImpl();

    public ModelData getModelData() {
        return modelData;
    }

    public void setModelData(ModelData modelData) {
        this.modelData = modelData;
    }

    public void setActiveAndPreviousObject(Object mainObject) {
        if (modelData.getActiveObject() != null) {
            modelData.setPreviousObject(modelData.getActiveObject());
        }

        modelData.setActiveObject(mainObject);
    }

    public void removeActiveObjectData() {
        modelData.setProjectList(new ArrayList<>());
        modelData.setTasksList(new ArrayList<>());
        modelData.setAssigneeList(new ArrayList<>());
        modelData.setClientList(new ArrayList<>());
        modelData.setTasksList(new ArrayList<>());
    }

    public void loadAllProjects() {
        modelData.setProjectList(projectService.getAllProjects());
    }

    public void loadAllTasks() {
        modelData.setTasksList(taskService.getAllTasks());
    }

    public void loadAllAssignees() {
        modelData.setAssigneeList(assigneeService.getAllAssignees());
    }

    public void loadAllClients() {
        modelData.setClientList(clientService.getAllClients());
    }

    public void loadAllTeamleads() {
        modelData.setTeamleadsList(teamleadService.getAllTeamleads());
    }

    public void loadProjectsForMainObject() {
        Object mainObject = modelData.getActiveObject();
        String mainObjectClass = mainObject.getClass().getSimpleName();

        switch (mainObjectClass) {
            case "Task":
                Task task = (Task) mainObject;
                modelData.setProjectList(Collections.singletonList(projectService.getProjectByTask(task)));
                break;
            case "Assignee":
                Assignee assignee = (Assignee) mainObject;
                modelData.setProjectList(projectService.getProjectsByAssignee(assignee));
                break;
            case "Client":
                Client client = (Client) mainObject;
                modelData.setProjectList(projectService.getProjectsByClient(client));
                break;
            case "Teamlead":
                Teamlead teamlead = (Teamlead) mainObject;
                modelData.setProjectList(projectService.getProjectsByTeamlead(teamlead));
        }
    }

    public void loadTasksForMainObject() {
        Object mainObject = modelData.getActiveObject();
        String mainObjectClass = mainObject.getClass().getSimpleName();

        switch (mainObjectClass) {
            case "Project":
                Project project = (Project) mainObject;
                modelData.setTasksList(taskService.getTasksByProject(project));
                break;
            case "Assignee":
                Assignee assignee = (Assignee) mainObject;
                modelData.setTasksList(taskService.getTasksByAssignee(assignee));
                break;
        }
    }

    public void loadAssigneesForMainObject() {
        Object mainObject = modelData.getActiveObject();
        String mainObjectClass = mainObject.getClass().getSimpleName();

        switch (mainObjectClass) {
            case "Project":
                Project project = (Project) mainObject;
                modelData.setAssigneeList(assigneeService.getAssigneesByProject(project));
                break;
            case "Task":
                Task task = (Task) mainObject;
                modelData.setAssigneeList(assigneeService.getAssigneesByTask(task));
                break;
            case "Teamlead":
                Teamlead teamlead = (Teamlead) mainObject;
                modelData.setAssigneeList(assigneeService.getAssigneesByTeamLead(teamlead));
        }
    }

    public void loadTeamleadsForMainObject() {
        Object mainObject = modelData.getActiveObject();
        String mainObjectClass = mainObject.getClass().getSimpleName();

        switch (mainObjectClass) {
            case "Project":
                Project project = (Project) mainObject;
                modelData.setTeamleadsList(Collections.singletonList(teamleadService.getTeamleadByProject(project)));
                break;
            case "Assignee":
                Assignee assignee = (Assignee) mainObject;
                modelData.setTeamleadsList(Collections.singletonList(teamleadService.getTeamleadByAssignee(assignee)));
        }
    }

    public void changeProjectData(String id, String name, String description, Date created, Date deadline) {
        try {
            projectService.createOrUpdateProject(id, name, description, created, deadline);
        } catch (ObjectIsNotPersistentException e) {
            e.printStackTrace();
        }
    }

    public void changeTaskData(String id, String name, String description, Date created, Date deadline) {
        try {
            taskService.createOrUpdateTask(id, name, description, created, deadline);
        } catch (ObjectIsNotPersistentException e) {
            e.printStackTrace();
        }
    }

    public void changeAssigneeData(String id, String name, String firstName, String lastName) {
        try {
            assigneeService.createOrUpdateAssignee(id, name, firstName, lastName);
        } catch (ObjectIsNotPersistentException e) {
            e.printStackTrace();
        }
    }

    public void changeTeamleadData(String id, String name) {
        try {
            teamleadService.createOrUpdateTeamlead(id, name);
        } catch (ObjectIsNotPersistentException e) {
            e.printStackTrace();
        }
    }

    public void changeClientData(String id, String name) {
        try {
            clientService.createOrUpdateClient(id, name);
        } catch (ObjectIsNotPersistentException e) {
            e.printStackTrace();
        }
    }
}
