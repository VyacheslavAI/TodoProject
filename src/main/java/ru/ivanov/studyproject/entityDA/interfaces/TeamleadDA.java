package ru.ivanov.studyproject.entityDA.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Teamlead;

import java.util.List;

public interface TeamleadDA {

    Teamlead getTeamleadByPosition(String position);

    Teamlead getTeamleadByAssignee(Assignee assignee);

    Teamlead getTeamleadByAssignees(List<Assignee> assignees);
}
