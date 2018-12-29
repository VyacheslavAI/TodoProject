package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.List;

//TODO; create dependencies for delete or add assignees

public enum Teamlead {

    TeamLead_one("teamlead_one"),

    TeamLead_two("teamlead_two"),

    TeamLead_three("teamlead_three");

    private String position;

    private List<Assignee> assignees = new ArrayList<>();

    Teamlead(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }
}
