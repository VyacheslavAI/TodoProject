package ru.ivanov.studyproject.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String id;

    private String companyName;

    private final List<Project> projects = new ArrayList<>();

    public Client() {
        id = "0";
        companyName = "anonymous client";
    }

    public Client(String companyName) {
        id = "0";
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
