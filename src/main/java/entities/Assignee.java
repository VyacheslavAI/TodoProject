package entities;

//TODO: set final values

import java.util.List;

public class Assignee {
    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    private TeamLead teamLead;

    private List<Project> projects;

    private List<Task> tasks;

    public Assignee(String id, String firstName, String lastName, TeamLead teamLead) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamLead = teamLead;
    }

    public Assignee(String id, String firstName, String lastName, TeamLead teamLead, List<Project> projects) {
        this(id, firstName, lastName, teamLead);
        this.projects = projects;
    }

    public Assignee(String id, String firstName, String lastName, TeamLead teamLead, List<Project> projects, List<Task> tasks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamLead = teamLead;
        this.projects = projects;
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

    public TeamLead getTeamLead() {
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

    public void setTeamLead(TeamLead teamLead) {
        this.teamLead = teamLead;
    }
}