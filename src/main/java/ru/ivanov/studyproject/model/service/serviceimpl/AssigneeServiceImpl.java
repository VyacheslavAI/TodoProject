package ru.ivanov.studyproject.model.service.serviceimpl;

import ru.ivanov.studyproject.dao.interfaces.AssigneeDA;
import ru.ivanov.studyproject.dao.memoryImpl.AssigneeDAO;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;
import ru.ivanov.studyproject.model.service.serviceinterfaces.AssigneeService;

import java.util.List;

public class AssigneeServiceImpl implements AssigneeService {

    private final AssigneeDA assigneeDA = new AssigneeDAO();

    @Override
    public List<Assignee> getAssigneesByFullName(String fullName) {
        return assigneeDA.getAssigneesByFullName(fullName);
    }

    @Override
    public Assignee createOrUpdateAssignee(String id, String name, String firstName, String lastName) throws ObjectIsNotPersistentException {
        Assignee assignee = new Assignee(id, firstName, lastName);
        return assigneeDA.createOrUpdateAssignee(assignee);
    }

    @Override
    public List<Assignee> getAssigneesByTeamLead(Teamlead teamLead) {
        return assigneeDA.getAssigneesByTeamLead(teamLead);
    }

    @Override
    public List<Assignee> getAssigneesByProject(Project project) {
        return assigneeDA.getAssigneesByProject(project);
    }

    @Override
    public List<Assignee> getAssigneesByTask(Task task) {
        return assigneeDA.getAssigneesByTask(task);
    }

    @Override
    public List<String> getRelationNames() {
        return assigneeDA.getRelationNames();
    }

    @Override
    public List<Assignee> getAllAssignees() {
        return assigneeDA.getAllAssignees();
    }
}
