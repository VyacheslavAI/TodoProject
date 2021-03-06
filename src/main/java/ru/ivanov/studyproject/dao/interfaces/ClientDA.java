package ru.ivanov.studyproject.dao.interfaces;

import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.List;

public interface ClientDA {

    Client getClientByCompanyName(String companyName);

    Client getClientByProjectName(String projectName);

    Client createOrUpdateClient(Client client) throws ObjectIsNotPersistentException;

    List<String> getRelationNames();

    List<Client> getAllClients();
}
