package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.List;

public class Teamlead {

    private String id;

    private String position;

    private final List<Project> projects = new ArrayList<>();

    private final List<Assignee> assignees = new ArrayList<>();

    public Teamlead() {
        id = "0";
        position = "no position";
    }

    public Teamlead(String position) {
        id = "0";
        this.position = position;
    }

    public Teamlead(String id, String position) {
        this.id = id;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
