package ru.ivanov.studyproject.repositories;

import ru.ivanov.studyproject.entities.*;

import java.util.HashMap;
import java.util.Map;

public class MemoryMapRepo {

    public final static Map<String, Assignee> ASSIGNEE_MAP = new HashMap<>();

    public final static Map<String, Client> CLIENT_MAP = new HashMap<>();

    public final static Map<String, Project> PROJECT_MAP = new HashMap<>();

    public final static Map<String, ResponsiblePerson> PERSON_MAP = new HashMap<>();

    public final static Map<String, Task> TASK_MAP = new HashMap<>();

    public final static Map<String, Teamlead> TEAMLEAD_MAP = new HashMap<>();

}
