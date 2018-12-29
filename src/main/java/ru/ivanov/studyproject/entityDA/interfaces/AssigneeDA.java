package ru.ivanov.studyproject.entityDA.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;

import java.util.List;

public interface AssigneeDA {

    Assignee getAssigneeById(String id);

    List<Assignee> getAssigneesByFullName(String fullName);

    List<Assignee> getAssigneesByTeamLead(Teamlead teamLead);

    List<Assignee> getAssigneesByProject(Project project);

    List<Assignee> getAssigneeByTask(Task task);
}
