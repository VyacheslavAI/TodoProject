package ru.ivanov.studyproject.dao.memoryImpl;

import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.dao.interfaces.TeamleadDA;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.Arrays;
import java.util.List;

public class TeamleadDAO implements TeamleadDA {

    private final DataSource dataSource = DataSource.getDataSource();

    @Override
    public Teamlead getTeamleadByPosition(String position) {
        List<Teamlead> teamleads = dataSource.getAllEntityObjects(Teamlead.class);

        for (Teamlead teamlead : teamleads) {
            if (teamlead.getPosition().equals(position)) {
                return teamlead;
            }
        }

        return null;
    }

    @Override
    public Teamlead getTeamleadByAssignee(Assignee assignee) {
        try {
            return (Teamlead) dataSource.searchEntitiesByRelations(Arrays.asList(assignee), Teamlead.class).get(0);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Teamlead getTeamleadByProject(Project project) {
        try {
            return (Teamlead) dataSource.searchEntitiesByRelations(Arrays.asList(project), Teamlead.class).get(0);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Teamlead createOrUpdateTeamlead(Teamlead teamlead) throws ObjectIsNotPersistentException {
        return (Teamlead) dataSource.createOrUpdateEntity(teamlead);
    }

    @Override
    public List<String> getRelationNames() {
        return dataSource.getRelationships(Teamlead.class);
    }



    @Override
    public List<Teamlead> getAllTeamleads() {
        return dataSource.getAllEntityObjects(Teamlead.class);
    }
}
