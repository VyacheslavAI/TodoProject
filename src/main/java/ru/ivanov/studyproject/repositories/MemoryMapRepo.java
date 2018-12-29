package ru.ivanov.studyproject.repositories;

import ru.ivanov.studyproject.entities.*;
import ru.ivanov.studyproject.entityRelation.*;

import java.util.HashMap;
import java.util.Map;

public class MemoryMapRepo {

    public final static Map<Assignee, AssigneeRO> ASSIGNEE_MAP = new HashMap<>();

    public final static Map<Client, ClientRO> CLIENT_MAP = new HashMap<>();

    public final static Map<Project, ProjectRO> PROJECT_MAP = new HashMap<>();

    public final static Map<ResponsiblePerson, ResponsiblePersonRO> PERSON_MAP = new HashMap<>();

    public final static Map<Task, TaskRO> TASK_MAP = new HashMap<>();

    public final static Map<Teamlead, TeamleadRO> TEAMLEAD_MAP = new HashMap<>();


}
