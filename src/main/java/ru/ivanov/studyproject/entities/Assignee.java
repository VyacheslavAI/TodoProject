package ru.ivanov.studyproject.entities;

//TODO: set final values

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Assignee {

    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    private Teamlead teamLead;

    private List<Project> projects = new ArrayList<>();

    private List<Task> tasks = new ArrayList<>();

    public Assignee() {
        id = UUID.randomUUID().toString();
    }

    public Assignee(String firstName, String lastName, Teamlead teamLead) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamLead = teamLead;
    }

    public Assignee(String firstName, String lastName, Teamlead teamLead, List<Project> projects) {
        this(firstName, lastName, teamLead);
        this.projects = projects;
    }

    public Assignee(String firstName, String lastName, Teamlead teamLead, List<Project> projects, List<Task> tasks) {
        this(firstName, lastName, teamLead, projects);
        this.tasks = tasks;
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

    public Teamlead getTeamLead() {
        return teamLead;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Task> getTasks() {
        return tasks;
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

    public void setTeamLead(Teamlead teamLead) {
        this.teamLead = teamLead;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}