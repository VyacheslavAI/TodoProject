package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Project;

import java.util.ArrayList;
import java.util.List;

public class ClientRO {

    private final List<Project> project = new ArrayList<>();

    public List<Project> getProject() {
        return project;
    }
}
