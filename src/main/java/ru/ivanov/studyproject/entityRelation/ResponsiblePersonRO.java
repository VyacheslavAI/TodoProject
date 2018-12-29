package ru.ivanov.studyproject.entityRelation;

import ru.ivanov.studyproject.entities.Project;

import java.util.ArrayList;
import java.util.List;

public class ResponsiblePersonRO {

    private final List<Project> projects = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }
}
