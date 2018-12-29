package ru.ivanov.studyproject.entities;

//TODO; create dependencies for delete or add assignees

import java.util.UUID;

public enum Teamlead {

    TeamLead_one("teamlead_one"),

    TeamLead_two("teamlead_two"),

    TeamLead_three("teamlead_three");

    private String id;

    private String position;

    private String relationId;

    Teamlead(String position) {
        id = UUID.randomUUID().toString();
        this.position = position;
    }

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
