package ru.ivanov.studyproject.dao.impl;

import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.dao.interfaces.AssigneeDA;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;

import java.util.ArrayList;
import java.util.List;

public class AssigneeDAO implements AssigneeDA {

    private DataSource dataSource = DataSource.getDataSource();

    @Override
    public List<Assignee> getAssigneesByFullName(String fullName) {
        List<Assignee> assignees = dataSource.getAllEntityObjects(Assignee.class);
        List<Assignee> result = new ArrayList<>();

        for (Assignee assignee : assignees) {
            if (assignee.getFullName().equals(fullName))
                result.add(assignee);
        }

        return result;
    }

    @Override
    public List<Assignee> getAssigneesByTeamLead(Teamlead teamLead) {
        return null;
    }

    @Override
    public List<Assignee> getAssigneesByProject(Project project) {
        return null;
    }

    @Override
    public List<Assignee> getAssigneesByTask(Task task) {
        return null;
    }

    @Override
    public List<Assignee> getAllAssignees() {
        return null;
    }
}
