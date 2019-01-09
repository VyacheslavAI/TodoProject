package ru.ivanov.studyproject.model.service;

import ru.ivanov.studyproject.entities.*;

import java.util.List;

public class ModelData {

    private Object activeObject;

    private Object previousObject;

    private String classNameActiveObject;

    private List<Project> projectList;

    private List<Task> tasksList;

    private List<Assignee> assigneeList;

    private List<Client> clientList;

    private List<Teamlead> teamleadsList;

    public Object getActiveObject() {
        return activeObject;
    }

    public void setActiveObject(Object activeObject) {
        this.activeObject = activeObject;
        setClassNameActiveObject(activeObject.getClass().getSimpleName());
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public List<Assignee> getAssigneeList() {
        return assigneeList;
    }

    public void setAssigneeList(List<Assignee> assigneeList) {
        this.assigneeList = assigneeList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Teamlead> getTeamleadsList() {
        return teamleadsList;
    }

    public void setTeamleadsList(List<Teamlead> teamleadsList) {
        this.teamleadsList = teamleadsList;
    }

    public Object getPreviousObject() {
        return previousObject;
    }

    public void setPreviousObject(Object previousObject) {
        this.previousObject = previousObject;
    }

    public String getClassNameActiveObject() {
        return classNameActiveObject;
    }

    public void setClassNameActiveObject(String classNameActiveObject) {
        this.classNameActiveObject = classNameActiveObject;
    }
}
