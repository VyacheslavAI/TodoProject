package ru.ivanov.studyproject.view;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.model.service.ModelData;
import ru.ivanov.studyproject.utils.ConsoleHelper;

import java.util.List;

public class TaskView implements View {

    private Task task;

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void selectSection() {
        ConsoleHelper.printMessage(
                String.format(
                        "Name: %s%n" +
                                "Description: %s%n" +
                                "Created: %s%n" +
                                "Deadline: %s%n",
                        task.getName(),
                        task.getDescription(),
                        task.getCreated().toString(),
                        task.getDeadline().toString()));

        ConsoleHelper.printMessage("0: Project");
        ConsoleHelper.printMessage("1: Assignees");
        ConsoleHelper.printMessage("3: Delete Task");
        ConsoleHelper.printMessage("4: Edit information");
        ConsoleHelper.printMessage("5: Return to main menu");

        int selectedSection = ConsoleHelper.readInt();

        switch (selectedSection) {
            case 1:
                controller.selectProjectSection();
            case 2:
                controller.selectAssigneeSection();
            case 3:
                controller.selectDeleteSection();
            case 4:
                controller.selectEditSection();
            case 5:
                controller.selectReturnToMenuSection();
        }
    }

    public void showAllObjects(ModelData modelData) {
        List<Task> tasks = modelData.getTasksList();

        for (int i = 0; i < tasks.size(); i++) {
            ConsoleHelper.printMessage(String.format("%d %s", i, tasks.get(i).getName()));
        }

        int selectedTask = ConsoleHelper.readInt();

        controller.selectTask(tasks.get(selectedTask));
    }
}
