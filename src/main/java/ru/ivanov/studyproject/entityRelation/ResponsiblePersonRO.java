package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResponsiblePersonRO {

    private String id;

    public ResponsiblePersonRO() {
        id = UUID.randomUUID().toString();
    }

    private final List<Project> projects = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }
}
