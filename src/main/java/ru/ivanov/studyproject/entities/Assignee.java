package ru.ivanov.studyproject.entities;

//TODO: set final values

import java.util.ArrayList;
import java.util.List;

public class Assignee {

    private String id;

    private String name;

    private String firstName;

    private String lastName;

    private final List<Project> projects = new ArrayList<>();

    private final List<Task> tasks = new ArrayList<>();

    private final List<Teamlead> teamlead = new ArrayList<>();

    public Assignee() {
        id = "0";
        firstName = "noname";
        lastName = "noname";
        name = "noname";
    }

    public Assignee(String firstName, String lastName) {
        id = "0";
        this.firstName = firstName;
        this.lastName = lastName;
        name = String.format("%s %s", firstName, lastName);
    }

    public Assignee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        name = String.format("%s %s", firstName, lastName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
}