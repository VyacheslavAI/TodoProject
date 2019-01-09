package ru.ivanov.studyproject.view;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.model.service.ModelData;
import ru.ivanov.studyproject.utils.ConsoleHelper;

import java.util.List;

public class ClientView implements View {

    private Client client;

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void selectSection() {
        ConsoleHelper.printMessage(
                String.format(
                        "Name: %s%n",
                        client.getName()));

        ConsoleHelper.printMessage("1: Project");
        ConsoleHelper.printMessage("2: Delete Client");
        ConsoleHelper.printMessage("3: Edit information");
        ConsoleHelper.printMessage("4: Return to main menu");

        int selectedSection = ConsoleHelper.readInt();

        switch (selectedSection) {
            case 1:
                controller.selectProjectSection();
            case 2:
                controller.deleteClient();
            case 3:
                editSection();
            case 4:
                controller.selectReturnToMenuSection();
        }
    }

    public void showAllObjects(ModelData modelData) {
        List<Client> clients = modelData.getClientList();

        for (int i = 0; i < clients.size(); i++) {
            ConsoleHelper.printMessage(String.format("%d %s", i, clients.get(i).getName()));
        }

        int selectedProject = ConsoleHelper.readInt();

        controller.selectClient(clients.get(selectedProject));
    }

    public void editSection() {
        int commandNumber = 0;

        String name = client.getName();

        ConsoleHelper.printMessage("Please enter field number for edit");
        ConsoleHelper.printMessage("1: Name");
        ConsoleHelper.printMessage("2: Exit edit form");

        while (commandNumber != 2) {
            commandNumber = ConsoleHelper.readInt();

            switch (commandNumber) {
                case 1: {
                    ConsoleHelper.printMessage("Please enter company name or \n" +
                            "leave the field empty if you do not want to change it");
                    name = ConsoleHelper.readString();
                }
            }
        }

        controller.editClient(client.getId(), name);
    }
}
