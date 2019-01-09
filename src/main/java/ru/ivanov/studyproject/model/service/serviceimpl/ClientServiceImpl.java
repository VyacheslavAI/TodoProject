package ru.ivanov.studyproject.model.service.serviceimpl;

import ru.ivanov.studyproject.dao.interfaces.ClientDA;
import ru.ivanov.studyproject.dao.memoryImpl.ClientDAO;
import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;
import ru.ivanov.studyproject.model.service.serviceinterfaces.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientDA clientDA = new ClientDAO();

    @Override
    public Client createOrUpdateClient(String id, String name) throws ObjectIsNotPersistentException {
        Client client = new Client(id, name);
        return clientDA.createOrUpdateClient(client);
    }

    @Override
    public Client getClientByCompanyName(String companyName) {
        return clientDA.getClientByCompanyName(companyName);
    }

    @Override
    public Client getClientByProjectName(String projectName) {
        return clientDA.getClientByProjectName(projectName);
    }

    @Override
    public List<String> getRelationNames() {
        return clientDA.getRelationNames();
    }

    @Override
    public List<Client> getAllClients() {
        return clientDA.getAllClients();
    }
}
