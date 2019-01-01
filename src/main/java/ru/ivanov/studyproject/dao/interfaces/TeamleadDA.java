package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Teamlead;

import java.util.List;

public interface TeamleadDA {

    Teamlead getTeamleadByPosition(String position);

    Teamlead getTeamleadByAssignee(Assignee assignee);

    List<Teamlead> getAllTeamleads();
}
