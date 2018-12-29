package ru.ivanov.studyproject.entityDA.interfacesDA;

import ru.ivanov.studyproject.entities.Client;

public interface ClientDA {

    Client getClientById(String id);

    Client getClientByCompanyName(String companyName);
}
