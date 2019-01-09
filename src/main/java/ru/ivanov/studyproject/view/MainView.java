package ru.ivanov.studyproject.view;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.utils.ConsoleHelper;

public class MainView implements View {

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void selectSection() {
        ConsoleHelper.printMessage("1: Projects");
        ConsoleHelper.printMessage("2: Tasks");
        ConsoleHelper.printMessage("3: Assignees");
        ConsoleHelper.printMessage("4: Teamlead");
        ConsoleHelper.printMessage("5: Client");
        ConsoleHelper.printMessage("6: Exit");

        int selectedSection = ConsoleHelper.readInt();

        controller.onSelectSection(selectedSection);
    }
}
