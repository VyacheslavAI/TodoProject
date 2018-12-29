package ru.ivanov.studyproject.entityDA.entityDAO;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.entityDA.interfaces.AssigneeDA;
import ru.ivanov.studyproject.repositories.MemoryMapRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssigneeMemoryMapDAO implements AssigneeDA {

    @Override
    public Assignee getAssigneeById(String id) {
        return MemoryMapRepo.ASSIGNEE_MAP.get(id);
    }

    @Override
    public List<Assignee> getAssigneesByFullName(String fullName) {
        Map<String, Assignee> assigneeMap = MemoryMapRepo.ASSIGNEE_MAP;

        List<Assignee> assignees = new ArrayList<>();

        for (Assignee assignee : assigneeMap.values()) {
            if (assignee.getFullName().equals(fullName))
                assignees.add(assignee);
        }

        return assignees;
    }

    @Override
    public List<Assignee> getAssigneesByTeamLead(Teamlead teamLead) {

        return null;
    }

    @Override
    public List<Assignee> getAssigneesByProject(Project project) {
        Map<String, Assignee> assigneeMap = MemoryMapRepo.ASSIGNEE_MAP;

        List<Assignee> result = new ArrayList<>();
        return null;
    }

    @Override
    public List<Assignee> getAssigneeByTask(Task task) {
        Map<String, Assignee> assigneeMap = MemoryMapRepo.ASSIGNEE_MAP;

        List<Assignee> result = new ArrayList<>();
        return null;
    }
}
