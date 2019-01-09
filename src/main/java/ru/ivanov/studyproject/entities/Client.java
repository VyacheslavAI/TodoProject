package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String id;

    private String name;

    private final List<Project> projects = new ArrayList<>();

    public Client() {
        id = "0";
        name = "anonymous client";
    }

    public Client(String name) {
        id = "0";
        this.name = name;
    }

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
