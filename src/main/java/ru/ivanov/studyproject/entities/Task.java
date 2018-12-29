package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


//TODO: initialize list

public class Task {

    private final String id;

    private final Project project;

    private String description;

    private final Date created;

    private Date deadline;

    private List<Assignee> assignees = new ArrayList<>();

    public Task(Project project) {
        id = UUID.randomUUID().toString();
        this.project = project;
        created = new Date();
    }

    public Task(Project project, String description) {
        this(project);
        this.description = description;
    }

    public Task(Project project, String description, Date deadline) {
        this(project, description);
        this.deadline = deadline;
    }

    public Task(Project project, String description, List<Assignee> assignees) {
        this(project, description);
        this.assignees = assignees;
    }

    public Task(Project project, String description, Date deadline, List<Assignee> assignees) {
        this(project, description);
        this.deadline = deadline;
        this.assignees = assignees;
    }

    public String getId() {
        return id;
    }

    public Project getProject() {
        return project;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
