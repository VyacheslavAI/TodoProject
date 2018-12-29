package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TeamleadRO {

    private final List<Assignee> assignees = new ArrayList<>();

    private final List<Project> projects = new ArrayList<>();

    private final List<Task> tasks = new ArrayList<>();

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
