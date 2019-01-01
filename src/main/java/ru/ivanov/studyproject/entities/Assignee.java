package ru.ivanov.studyproject.entities;

//TODO: set final values

import java.util.ArrayList;
import java.util.List;

public class Assignee {

    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    private final List<Project> projects = new ArrayList<>();

    private final List<Task> tasks = new ArrayList<>();

    private final List<Teamlead> teamlead = new ArrayList<>();

    public Assignee() {
        id = "0";
        firstName = "noname";
        lastName = "noname";
        fullName = "noname";
    }

    public Assignee(String firstName, String lastName) {
        id = "0";
        this.firstName = firstName;
        this.lastName = lastName;
        fullName = String.format("%s %s", firstName, lastName);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}