package ru.ivanov.studyproject.view;

import java.util.ArrayList;
import java.util.List;

public enum Section {
    PROJECTS("Project"),
    TASKS("Task"),
    ASSIGNEES("Assignee"),
    TEAMLEADS("Teamlead"),
    CLIENTS("Client"),
    EDIT("Edit"),
    DELETE("Delete"),
    EXIT("Exit");

    private final String name;

    private final static List<Section> sections = new ArrayList<>();

    static {
        sections.add(PROJECTS);
        sections.add(TASKS);
        sections.add(ASSIGNEES);
        sections.add(TEAMLEADS);
        sections.add(CLIENTS);
        sections.add(EDIT);
        sections.add(DELETE);
        sections.add(EXIT);
    }

    Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Section> getSections() {
        return sections;
    }
}
