package ru.ivanov.studyproject.dao.memoryImpl;

import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.dao.interfaces.AssigneeDA;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssigneeDAO implements AssigneeDA {

    private DataSource dataSource = DataSource.getDataSource();

    @Override
    public List<Assignee> getAssigneesByFullName(String fullName) {
        List<Assignee> assignees = dataSource.getAllEntityObjects(Assignee.class);
        List<Assignee> result = new ArrayList<>();

        for (Assignee assignee : assignees) {
            if (assignee.getName().equals(fullName))
                result.add(assignee);
        }

        return result;
    }

    @Override
    public List<Assignee> getAssigneesByTeamLead(Teamlead teamLead) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(teamLead), Assignee.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Assignee> getAssigneesByProject(Project project) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(project), Assignee.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Assignee> getAssigneesByTask(Task task) {
        try {
            return dataSource.searchEntitiesByRelations(Arrays.asList(task), Assignee.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Assignee createOrUpdateAssignee(Assignee assignee) throws ObjectIsNotPersistentException {
        return (Assignee) dataSource.createOrUpdateEntity(assignee);
    }

    @Override
    public List<String> getRelationNames() {
        return dataSource.getRelationships(Assignee.class);
    }

    @Override
    public List<Assignee> getAllAssignees() {
        return dataSource.getAllEntityObjects(Assignee.class);
    }
}
