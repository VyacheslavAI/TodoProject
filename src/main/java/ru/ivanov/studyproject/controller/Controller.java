package ru.ivanov.studyproject.controller;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.model.service.MainModel;
import ru.ivanov.studyproject.view.*;

import java.util.Date;

public class Controller {

    private MainModel mainModel = new MainModel();

    private MainView mainView = new MainView();

    private ProjectView projectView = new ProjectView();

    private TaskView taskView = new TaskView();

    private AssigneeView assigneeView = new AssigneeView();

    private TeamleadView teamleadView = new TeamleadView();

    private ClientView clientView = new ClientView();

    public MainView getMainView() {
        return mainView;
    }

    public Controller() {
        mainView.setController(this);
        projectView.setController(this);
        taskView.setController(this);
        assigneeView.setController(this);
        teamleadView.setController(this);
        clientView.setController(this);
    }

    public void onSelectSection(int section) {
        switch (section) {
            case 1:
                mainModel.loadAllProjects();
                projectView.showAllObjects(mainModel.getModelData());
                break;
            case 2:
                mainModel.loadAllTasks();
                taskView.showAllObjects(mainModel.getModelData());
                break;
            case 3:
                mainModel.loadAllAssignees();
                assigneeView.showAllObjects(mainModel.getModelData());
                break;
            case 4:
                mainModel.loadAllTeamleads();
                teamleadView.showAllObjects(mainModel.getModelData());
                break;
            case 5:
                mainModel.loadAllClients();
                clientView.showAllObjects(mainModel.getModelData());
                break;
        }
    }

    public void selectProject(Project project) {
        mainModel.setActiveAndPreviousObject(project);
        projectView.setProject(project);
        projectView.selectSection();
    }

    public void selectTask(Task task) {
        mainModel.setActiveAndPreviousObject(task);
        taskView.setTask(task);
        taskView.selectSection();
    }

    public void selectAssignee(Assignee assignee) {
        mainModel.setActiveAndPreviousObject(assignee);
        assigneeView.setAssignee(assignee);
        assigneeView.selectSection();
    }

    public void selectTeamlead(Teamlead teamlead) {
        mainModel.setActiveAndPreviousObject(teamlead);
        teamleadView.setTeamlead(teamlead);
        teamleadView.selectSection();
    }

    public void selectClient(Client client) {
        mainModel.setActiveAndPreviousObject(client);
        clientView.setClient(client);
        clientView.selectSection();
    }

    public void selectProjectSection() {
        mainModel.loadProjectsForMainObject();
        projectView.showAllObjects(mainModel.getModelData());
    }

    public void selectTaskSection() {
        mainModel.loadTasksForMainObject();
        taskView.showAllObjects(mainModel.getModelData());
    }

    public void selectAssigneeSection() {
        mainModel.loadAssigneesForMainObject();
        assigneeView.showAllObjects(mainModel.getModelData());
    }

    public void selectTeamleadSection() {
        mainModel.loadTeamleadsForMainObject();
        teamleadView.showAllObjects(mainModel.getModelData());
    }

    public void selectClientSection() {
        mainModel.loadAllClients();
        clientView.showAllObjects(mainModel.getModelData());
    }

    public void editProject(String id, String name, String description, Date created, Date deadline) {
        mainModel.changeProjectData(id, name, description, created, deadline);
    }

    public void editTask(String id, String name, String description, Date created, Date deadline) {
        mainModel.changeTaskData(id, name, description, created, deadline);
    }

    public void editAssignee(String id, String name, String firstName, String lastName) {
        mainModel.changeAssigneeData(id, name, firstName, lastName);
    }

    public void editTeamlead(String id, String name) {
        mainModel.changeTeamleadData(id, name);
    }

    public void editClient(String id, String name) {
        mainModel.changeClientData(id, name);
    }


    public void deleteProject() {

    }

    public void deleteTask() {

    }

    public void deleteAssignee() {

    }

    public void deleteTeamlead() {

    }

    public void deleteClient() {

    }

    public void selectReturnSection() {

    }

    public void selectReturnToMenuSection() {
        mainView.selectSection();
    }
}