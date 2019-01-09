package ru.ivanov.studyproject.view;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.model.service.ModelData;
import ru.ivanov.studyproject.utils.ConsoleHelper;

import java.util.List;

public class ProjectView implements View {

    private Project project;

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void selectSection() {
        ConsoleHelper.printMessage(
                String.format(
                        "Name: %s%n" +
                                "Description: %s%n" +
                                "Created: %s%n" +
                                "Deadline: %s%n",
                        project.getName(),
                        project.getDescription(),
                        project.getCreated().toString(),
                        project.getDeadline().toString()));

        ConsoleHelper.printMessage("1: Tasks");
        ConsoleHelper.printMessage("2: Assignees");
        ConsoleHelper.printMessage("3: Teamleads");
        ConsoleHelper.printMessage("4: Clients");
        ConsoleHelper.printMessage("5: Delete Project");
        ConsoleHelper.printMessage("6: Edit information");
        ConsoleHelper.printMessage("7: Return to main menu");

        int selectedSection = ConsoleHelper.readInt();

        switch (selectedSection) {
            case 1:
                controller.selectTaskSection();
            case 2:
                controller.selectAssigneeSection();
            case 3:
                controller.selectTeamleadSection();
            case 4:
                controller.selectClientSection();
            case 5:
                controller.deleteProject();
            case 6:
                editSection();
            case 7:
                controller.selectReturnToMenuSection();
        }
    }

    public void showAllObjects(ModelData modelData) {
        List<Project> projects = modelData.getProjectList();

        for (int i = 0; i < projects.size(); i++) {
            ConsoleHelper.printMessage(String.format("%d %s", i, projects.get(i).getName()));
        }

        int selectedProject = ConsoleHelper.readInt();

        controller.selectProject(projects.get(selectedProject));
    }

    public void editSection() {
//        int commandNumber = 0;
//
//        String name = project.getName();
//        String description = project.getDescription();
//
//        ConsoleHelper.printMessage("Please enter field number for edit");
//        ConsoleHelper.printMessage("1: first name");
//        ConsoleHelper.printMessage("2: last name");
//        ConsoleHelper.printMessage("3: Exit edit form");
//
//        while (commandNumber != 3) {
//            commandNumber = ConsoleHelper.readInt();
//
//            switch (commandNumber) {
//                case 1: {
//                    ConsoleHelper.printMessage("Please enter assignee firstName or \n" +
//                            "leave the field empty if you do not want to change it");
//                    firstName = ConsoleHelper.readString();
//                }
//                case 2: {
//                    ConsoleHelper.printMessage("Please enter assignee lastname or \n" +
//                            "leave the field empty if you do not want to change it");
//                    lastName = ConsoleHelper.readString();
//                }
//            }
//        }
//
//        String newName = String.format("%s %s", firstName, lastName);
//
//        controller.editAssignee(assignee.getId(), newName, firstName, lastName);
    }
}
