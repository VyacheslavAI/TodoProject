package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


//TODO: initialize list

public class Project {

    private String id;

    private Client client;

    private ResponsiblePerson person;

    private String description;

    private Date created;

    private Date deadline;

    private List<Task> tasks = new ArrayList<>();

    private List<Assignee> assignees = new ArrayList<>();

    public Project() {
        id = UUID.randomUUID().toString();
        created = new Date();
    }

    public Project(Client client, ResponsiblePerson person, String description) {
        id = UUID.randomUUID().toString();
        this.client = client;
        this.person = person;
        this.description = description;
    }

    public Project(Client client, ResponsiblePerson person, String description, Date deadline) {
        this(client, person, description);
        this.deadline = deadline;
    }

    public Project(Client client, ResponsiblePerson person, String description, List<Assignee> assignees) {
        this(client, person, description);
        this.assignees = assignees;
    }

    public Project(Client client, ResponsiblePerson person, String description, Date deadline, List<Assignee> assignees) {
        this(client, person, description);
        this.deadline = deadline;
        this.assignees = assignees;
    }

    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public ResponsiblePerson getPerson() {
        return person;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public Date getDeadline() {
        return deadline;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPerson(ResponsiblePerson person) {
        this.person = person;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }
}
