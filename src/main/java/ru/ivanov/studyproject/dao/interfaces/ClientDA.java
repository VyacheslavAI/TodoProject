package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Client;

public interface ClientDA {

    Client getClientById(String id);

    Client getClientByCompanyName(String companyName);
}
