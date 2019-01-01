package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//TODO: initialize list

public class Task {

    private String id;

    private String description;

    private final Date created;

    private Date deadline;

    private final List<Assignee> assignees = new ArrayList<>();

    private final List<Project> project = new ArrayList<>();

    public Task() {
        id = "0";
        description = "no description";
        created = new Date();
        deadline = new Date(92461953242369L);
    }

    public Task(String description) {
        id = "0";
        this.description = description;
        created = new Date();
        deadline = new Date(92461953242369L);
    }

    public Task(String description, Date deadline) {
        id = "0";
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

}
