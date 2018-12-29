package ru.ivanov.studyproject.entityDA.interfaces;

import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.ResponsiblePerson;

import java.util.List;

public interface ResponsiblePersonDA {

    ResponsiblePerson getResponsiblePersonByProject(Project project);

    ResponsiblePerson getResponsiblePersonByProjects(List<Project> projectList);

    ResponsiblePerson getResponsiblePersonByPosition(String position);
}
