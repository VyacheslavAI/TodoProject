package ru.ivanov.studyproject.model.service.serviceinterfaces;

import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.List;

public interface ClientService {

    Client getClientByCompanyName(String companyName);

    Client getClientByProjectName(String projectName);

    Client createOrUpdateClient(String id, String name) throws ObjectIsNotPersistentException;

    List<String> getRelationNames();

    List<Client> getAllClients();
}
