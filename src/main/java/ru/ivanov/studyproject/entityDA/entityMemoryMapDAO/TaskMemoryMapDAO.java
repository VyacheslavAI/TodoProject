package ru.ivanov.studyproject.entityDA.entityMemoryMapDAO;

import ru.ivanov.studyproject.entities.Assignee;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.Task;
import ru.ivanov.studyproject.entityDA.interfacesDA.TaskDA;

import java.util.Date;
import java.util.List;

public class TaskMemoryMapDAO implements TaskDA {

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public Task getTaskByProject(Project project) {
        return null;
    }

    @Override
    public Task getTaskByCreated(Date created) {
        return null;
    }

    @Override
    public Task getTaskByDeadline(Date deadline) {
        return null;
    }

    @Override
    public Task getTaskByAssignee(Assignee assignee) {
        return null;
    }

    @Override
    public Task getTaskByAssignees(List<Assignee> assigneeList) {
        return null;
    }
}
