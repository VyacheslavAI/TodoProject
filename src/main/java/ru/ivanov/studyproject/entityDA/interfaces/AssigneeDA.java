package ru.ivanov.studyproject.entityDA.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;

public interface AssigneeDA {

    Assignee getAssigneeById(String id);

    Assignee getAssigneesByFullName(String fullName);

    Assignee getAssigneesByTeamLead(Teamlead teamLead);

    Assignee getAssigneesByProject(Project project);

    Assignee getAssigneeByTask(Task task);
}
