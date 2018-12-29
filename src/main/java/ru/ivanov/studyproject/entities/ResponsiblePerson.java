package ru.ivanov.studyproject.entities;

import java.util.UUID;

public enum ResponsiblePerson {

    Manager_one("manager_one"),

    Manager_two("manager_two"),

    Manager_three("manager_three");

    ResponsiblePerson(String position) {
        id = UUID.randomUUID().toString();
        this.position = position;
    }

    private String id;

    private String relationId;

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}