package ru.ivanov.studyproject.entities;

//TODO: set final values

import java.util.UUID;

public class Assignee {

    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    public Assignee() {
        id = UUID.randomUUID().toString();
    }

    public Assignee(String firstName, String lastName) {
        this();
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

    public void setId(String id) {
        this.id = id;
    }

}