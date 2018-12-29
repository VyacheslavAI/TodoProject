package ru.ivanov.studyproject.entities;

//TODO; create dependencies for delete or add assignees

public enum Teamlead {

    TeamLead_one("teamlead_one"),

    TeamLead_two("teamlead_two"),

    TeamLead_three("teamlead_three");

    private String position;

    Teamlead(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
