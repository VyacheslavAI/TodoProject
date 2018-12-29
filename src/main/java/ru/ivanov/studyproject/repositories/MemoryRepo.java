package ru.ivanov.studyproject.repositories;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepo {

    public final List<Assignee> assignees = new ArrayList<>();

    public final List<Client> clients = new ArrayList<>();

    public final List<Project> projects = new ArrayList<>();

    public final List<Task> tasks = new ArrayList<>();
}
