package ru.ivanov.studyproject.entityDA.interfacesDA;

import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.entities.ResponsiblePerson;

public interface ResponsiblePersonDA {

    ResponsiblePerson getResponsiblePersonByProject(Project project);

    ResponsiblePerson getResponsiblePersonByPosition(String position);
}
