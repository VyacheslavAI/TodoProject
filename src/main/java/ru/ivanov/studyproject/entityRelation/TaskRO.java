package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRO {

    private String id;

    private final List<Assignee> assignees = new ArrayList<>();

    private Project project;

    public TaskRO() {
        id = UUID.randomUUID().toString();
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
