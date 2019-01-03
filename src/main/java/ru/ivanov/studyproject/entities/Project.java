package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO: initialize list

public class Project {

    private String id;

    private String name;

    private String description;

    private Date created;

    private Date deadline;

    private final List<Assignee> assignees = new ArrayList<>();

    private final List<Task> tasks = new ArrayList<>();

    public Project() {
        id = "0";
        name = "no name";
        description = "no description";
        created = new Date();
        deadline = new Date(92461953242369L);
    }

    public Project(String name, String description) {
        id = "0";
        this.name = name;
        this.description = description;
        created = new Date();
        deadline = new Date(92461953242369L);
    }

    public Project(String name, String description, Date deadline) {
        id = "0";
        this.name = name;
        this.description = description;
        created = new Date();
        this.deadline = deadline;
    }

    public String getId() {
        return id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
