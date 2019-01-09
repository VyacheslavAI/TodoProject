package ru.ivanov.studyproject.model.service.serviceimpl;

import ru.ivanov.studyproject.dao.interfaces.TeamleadDA;
import ru.ivanov.studyproject.dao.memoryImpl.TeamleadDAO;
import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;
import ru.ivanov.studyproject.model.service.serviceinterfaces.TeamleadService;

import java.util.List;

public class TeamleadServiceImpl implements TeamleadService {

    private final TeamleadDA teamleadDA = new TeamleadDAO();

    @Override
    public Teamlead createOrUpdateTeamlead(String id, String position) throws ObjectIsNotPersistentException {
        Teamlead teamlead = new Teamlead(id, position);
        return teamleadDA.createOrUpdateTeamlead(teamlead);
    }

    @Override
    public Teamlead getTeamleadByPosition(String position) {
        return teamleadDA.getTeamleadByPosition(position);
    }

    @Override
    public Teamlead getTeamleadByAssignee(Assignee assignee) {
        return teamleadDA.getTeamleadByAssignee(assignee);
    }

    @Override
    public Teamlead getTeamleadByProject(Project project) {
        return teamleadDA.getTeamleadByProject(project);
    }

    @Override
    public List<String> getRelationNames() {
        return teamleadDA.getRelationNames();
    }

    @Override
    public List<Teamlead> getAllTeamleads() {
        return teamleadDA.getAllTeamleads();
    }
}
