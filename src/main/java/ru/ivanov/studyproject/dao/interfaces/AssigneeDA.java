package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;

import java.util.List;

public interface AssigneeDA {

    List<Assignee> getAssigneesByFullName(String fullName);

    List<Assignee> getAssigneesByTeamLead(Teamlead teamLead);

    List<Assignee> getAssigneesByProject(Project project);

    List<Assignee> getAssigneesByTask(Task task);

    List<Assignee> getAllAssignees();
}
