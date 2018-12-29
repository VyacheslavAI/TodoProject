package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AssigneeRO {

    private String id;

    private final List<Project> projects = new ArrayList<>();

    private final List<Task> tasks = new ArrayList<>();

    private Teamlead teamlead;

    public AssigneeRO() {
        id = UUID.randomUUID().toString();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Teamlead getTeamlead() {
        return teamlead;
    }

    public void setTeamlead(Teamlead teamlead) {
        this.teamlead = teamlead;
    }
}
