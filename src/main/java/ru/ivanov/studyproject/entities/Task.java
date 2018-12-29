package ru.ivanov.studyproject.entities;

import java.util.Date;
import java.util.UUID;


//TODO: initialize list

public class Task {

    private final String id;

    private String relationId;

    private String description;

    private final Date created;

    private Date deadline;

    public Task() {
        id = UUID.randomUUID().toString();
        created = new Date();
    }

    public Task(String description) {
        this();
        this.description = description;
    }

    public Task(String description, Date deadline) {
        this(description);
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

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
}
