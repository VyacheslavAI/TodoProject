package ru.ivanov.studyproject.model.service.serviceinterfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.List;

public interface AssigneeService {

    Assignee createOrUpdateAssignee(String id, String name, String firstName, String lastName) throws ObjectIsNotPersistentException;

    List<Assignee> getAssigneesByFullName(String fullName);

    List<Assignee> getAssigneesByTeamLead(Teamlead teamLead);

    List<Assignee> getAssigneesByProject(Project project);

    List<Assignee> getAssigneesByTask(Task task);

    List<String> getRelationNames();

    List<Assignee> getAllAssignees();
}
