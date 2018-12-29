package ru.ivanov.studyproject.entities;

public enum ResponsiblePerson {

    Manager_one("manager_one"),

    Manager_two("manager_two"),

    Manager_three("manager_three");

    ResponsiblePerson(String position) {
        this.position = position;
    }

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}