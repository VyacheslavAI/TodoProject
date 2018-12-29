package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.List;

public enum ResponsiblePerson {

    Manager_one("manager_one"),

    Manager_two("manager_two"),

    Manager_three("manager_three");

    ResponsiblePerson(String position) {
        this.position = position;
    }

    private String position;

    private List<Project> responsibleProjects = new ArrayList<>();

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Project> getResponsibleProjects() {
        return responsibleProjects;
    }

    public void setResponsibleProjects(List<Project> responsibleProjects) {
        this.responsibleProjects = responsibleProjects;
    }
}
