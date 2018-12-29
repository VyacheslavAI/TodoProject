package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;

import java.util.ArrayList;
import java.util.List;

public class TaskRO {

    private final List<Assignee> assignees = new ArrayList<>();

    private Project project;

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
