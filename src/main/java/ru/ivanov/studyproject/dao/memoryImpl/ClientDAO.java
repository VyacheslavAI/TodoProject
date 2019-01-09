package ru.ivanov.studyproject.dao.memoryImpl;

import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.dao.interfaces.ClientDA;
import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.entities.Project;
import ru.ivanov.studyproject.exceptions.ObjectIsNotPersistentException;

import java.util.List;

public class ClientDAO implements ClientDA {

    private final DataSource dataSource = DataSource.getDataSource();

    @Override
    public Client getClientByCompanyName(String companyName) {
        List<Client> clients = dataSource.getAllEntityObjects(Client.class);

        for (Client client : clients) {
            if (client.getName().equals(companyName)) {
                return client;
            }
        }

        return null;
    }

    @Override
    public Client getClientByProjectName(String projectName) {
        List<Client> clients = dataSource.getAllEntityObjects(Client.class);

        for (Client client : clients) {
            for (Project project : client.getProjects()) {
                if (project.getName().equals(projectName)) {
                    return client;
                }
            }
        }

        return null;
    }

    @Override
    public Client createOrUpdateClient(Client client) throws ObjectIsNotPersistentException {
        return (Client) dataSource.createOrUpdateEntity(client);
    }

    @Override
    public List<String> getRelationNames() {
        return dataSource.getRelationships(Client.class);
    }

    @Override
    public List<Client> getAllClients() {
        return dataSource.getAllEntityObjects(Client.class);
    }
}
