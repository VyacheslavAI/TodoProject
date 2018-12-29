package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.entities.ResponsiblePerson;
import ru.ivanov.studyproject.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class ProjectRO {

    private final List<Assignee> assignees = new ArrayList<>();

    private Client client;

    private ResponsiblePerson person;

    private final List<Task> tasks = new ArrayList<>();

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ResponsiblePerson getPerson() {
        return person;
    }

    public void setPerson(ResponsiblePerson person) {
        this.person = person;
    }
}
