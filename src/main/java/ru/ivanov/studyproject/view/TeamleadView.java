package ru.ivanov.studyproject.view;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.model.service.ModelData;
import ru.ivanov.studyproject.utils.ConsoleHelper;

import java.util.List;

public class TeamleadView implements View {

    private Teamlead teamlead;

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Teamlead getTeamlead() {
        return teamlead;
    }

    public void setTeamlead(Teamlead teamlead) {
        this.teamlead = teamlead;
    }

    public void selectSection() {
        ConsoleHelper.printMessage(
                String.format(
                        "Position: %s%n",
                        teamlead.getPosition()));

        ConsoleHelper.printMessage("1: Projects");
        ConsoleHelper.printMessage("2: Assignees");
        ConsoleHelper.printMessage("3: Delete Teamlead");
        ConsoleHelper.printMessage("4: Edit information");
        ConsoleHelper.printMessage("5: Return to main menu");

        int selectedSection = ConsoleHelper.readInt();

        switch (selectedSection) {
            case 1:
                controller.selectProjectSection();
            case 2:
                controller.selectAssigneeSection();
            case 3:
                controller.deleteTeamlead();
//            case 4: controller.editTeamlead();
            case 5:
                controller.selectReturnToMenuSection();
        }
    }

    public void showAllObjects(ModelData modelData) {
        List<Teamlead> teamleads = modelData.getTeamleadsList();

        for (int i = 0; i < teamleads.size(); i++) {
            ConsoleHelper.printMessage(String.format("%d %s", i, teamleads.get(i).getPosition()));
        }

        int selectedProject = ConsoleHelper.readInt();

        controller.selectTeamlead(teamleads.get(selectedProject));
    }
}
