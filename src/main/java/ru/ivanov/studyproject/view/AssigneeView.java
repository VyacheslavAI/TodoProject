package ru.ivanov.studyproject.view;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.model.service.ModelData;
import ru.ivanov.studyproject.utils.ConsoleHelper;

import java.util.List;

public class AssigneeView implements View {

    private Assignee assignee;

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public void selectSection() {
        ConsoleHelper.printMessage(
                String.format(
                        "Name: %s%n",
                        assignee.getName()));

        ConsoleHelper.printMessage("1: Tasks");
        ConsoleHelper.printMessage("2: Teamleads");
        ConsoleHelper.printMessage("3: Delete Assignee");
        ConsoleHelper.printMessage("4: Edit information");
        ConsoleHelper.printMessage("5: Return to main menu");

        int selectedSection = ConsoleHelper.readInt();

        switch (selectedSection) {
            case 1:
                controller.selectTaskSection();
            case 2:
                controller.selectTeamleadSection();
            case 3:
                controller.deleteAssignee();
            case 4:
                editSection();
            case 5:
                controller.selectReturnToMenuSection();
        }
    }

    public void showAllObjects(ModelData modelData) {
        List<Assignee> assignees = modelData.getAssigneeList();

        for (int i = 0; i < assignees.size(); i++) {
            ConsoleHelper.printMessage(String.format("%d %s", i, assignees.get(i).getName()));
        }

        int selectedProject = ConsoleHelper.readInt();

        controller.selectAssignee(assignees.get(selectedProject));
    }

    public void editSection() {
        int commandNumber = 0;
        String firstName = assignee.getFirstName();
        String lastName = assignee.getLastName();

        ConsoleHelper.printMessage("Please enter field number for edit");
        ConsoleHelper.printMessage("1: first name");
        ConsoleHelper.printMessage("2: last name");
        ConsoleHelper.printMessage("3: Exit edit form");

        while (commandNumber != 3) {
            commandNumber = ConsoleHelper.readInt();

            switch (commandNumber) {
                case 1: {
                    ConsoleHelper.printMessage("Please enter assignee firstName or \n" +
                            "leave the field empty if you do not want to change it");
                    firstName = ConsoleHelper.readString();
                }
                case 2: {
                    ConsoleHelper.printMessage("Please enter assignee lastname or \n" +
                            "leave the field empty if you do not want to change it");
                    lastName = ConsoleHelper.readString();
                }
            }
        }

        String newName = String.format("%s %s", firstName, lastName);

        controller.editAssignee(assignee.getId(), newName, firstName, lastName);
    }
}