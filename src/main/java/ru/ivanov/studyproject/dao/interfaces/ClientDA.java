package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Client;

import java.util.List;

public interface ClientDA {

    Client getClientByCompanyName(String companyName);

    Client getClientByProjectName(String projectName);

    List<Client> getAllClients();
}
