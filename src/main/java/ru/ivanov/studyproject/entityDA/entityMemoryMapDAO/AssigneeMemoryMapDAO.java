package ru.ivanov.studyproject.entityDA.entityMemoryMapDAO;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entities.Teamlead;
import ru.ivanov.studyproject.entityDA.interfacesDA.AssigneeDA;
import ru.ivanov.studyproject.entityRelation.AssigneeRO;
import ru.ivanov.studyproject.repositories.MemoryMapRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AssigneeMemoryMapDAO implements AssigneeDA {

    @Override
    public Assignee getAssigneeById(String assigneeId) {
        Set<Assignee> assigneeSet = MemoryMapRepo.ASSIGNEE_MAP.keySet();
        for (Assignee assignee : assigneeSet)
            if (assignee.getId().equals(assigneeId))
                return assignee;
        return null;
    }

    @Override
    public List<Assignee> getAssigneesByFullName(String fullName) {
        List<Assignee> assigneeList = new ArrayList<>(MemoryMapRepo.ASSIGNEE_MAP.keySet());
        for (Assignee assignee : assigneeList)
            if (assignee.getFullName().equals(fullName))
                assigneeList.add(assignee);
        return assigneeList;
    }

    @Override
    public List<Assignee> getAssigneesByTeamLead(Teamlead teamlead) {
        Map<Assignee, AssigneeRO> assigneeMap = MemoryMapRepo.ASSIGNEE_MAP;
        List<Assignee> assigneeList = new ArrayList<>();
        for (Map.Entry<Assignee, AssigneeRO> pair : assigneeMap.entrySet()) {
            Assignee assignee = pair.getKey();
            AssigneeRO assigneeRO = pair.getValue();
            Teamlead assigneeTeamlead = assigneeRO.getTeamlead();
            if (teamlead.getId().equals(assigneeTeamlead.getId()))
                assigneeList.add(assignee);
        }
        return assigneeList;
    }

    @Override
    public List<Assignee> getAssigneesByProject(Project project) {
        Map<Assignee, AssigneeRO> assigneeMap = MemoryMapRepo.ASSIGNEE_MAP;
        List<Assignee> assigneeList = new ArrayList<>();
        for (Map.Entry<Assignee, AssigneeRO> pair : assigneeMap.entrySet()) {
            Assignee assignee = pair.getKey();
            AssigneeRO assigneeRO = pair.getValue();
            List<Project> assigneeProjects = assigneeRO.getProjects();
            if (assigneeProjects.contains(project))
                assigneeList.add(assignee);
        }
        return assigneeList;
    }

    @Override
    public List<Assignee> getAssigneesByTask(Task task) {
        Map<Assignee, AssigneeRO> assigneeMap = MemoryMapRepo.ASSIGNEE_MAP;
        List<Assignee> assigneeList = new ArrayList<>();
        for (Map.Entry<Assignee, AssigneeRO> pair : assigneeMap.entrySet()) {
            Assignee assignee = pair.getKey();
            AssigneeRO assigneeRO = pair.getValue();
            List<Task> assigneeTasks = assigneeRO.getTasks();
            if (assigneeTasks.contains(task))
                assigneeList.add(assignee);
        }
        return assigneeList;
    }
}
