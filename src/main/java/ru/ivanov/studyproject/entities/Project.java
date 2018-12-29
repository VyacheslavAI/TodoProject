package ru.ivanov.studyproject.entities;

import java.util.Date;
import java.util.UUID;

//TODO: initialize list

public class Project {

    private String id;

    private String relationId;

    private String description;

    private Date created;

    private Date deadline;

    public Project() {
        id = UUID.randomUUID().toString();
        created = new Date();
    }

    public Project(String description) {
        this();
        this.description = description;
    }

    public Project(String description, Date deadline) {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
}
