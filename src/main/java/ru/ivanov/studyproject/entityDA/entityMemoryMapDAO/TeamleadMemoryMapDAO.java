package ru.ivanov.studyproject.entityDA.entityMemoryMapDAO;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.entityDA.interfacesDA.TeamleadDA;

import java.util.List;

public class TeamleadMemoryMapDAO implements TeamleadDA {

    @Override
    public Teamlead getTeamleadByPosition(String position) {
        return null;
    }

    @Override
    public Teamlead getTeamleadByAssignee(Assignee assignee) {
        return null;
    }

    @Override
    public Teamlead getTeamleadByAssignees(List<Assignee> assignees) {
        return null;
    }
}
