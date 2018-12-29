package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientRO {

    private String id;

    public ClientRO() {
        id = UUID.randomUUID().toString();
    }

    private final List<Project> project = new ArrayList<>();

    public List<Project> getProject() {
        return project;
    }
}
