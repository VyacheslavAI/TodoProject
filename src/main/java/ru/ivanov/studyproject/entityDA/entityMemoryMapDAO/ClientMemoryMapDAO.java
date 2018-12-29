package ru.ivanov.studyproject.entityDA.entityMemoryMapDAO;

import ru.ivanov.studyproject.entities.Client;
import ru.ivanov.studyproject.entityDA.interfacesDA.ClientDA;
import ru.ivanov.studyproject.entityRelation.ClientRO;
import ru.ivanov.studyproject.repositories.MemoryMapRepo;

import java.util.Map;
import java.util.Set;

public class ClientMemoryMapDAO implements ClientDA {

    @Override
    public Client getClientById(String id) {
        Map<Client, ClientRO> clientMap = MemoryMapRepo.CLIENT_MAP;
        Set<Client> clients = clientMap.keySet();
        for (Client client : clients) {
            if (client.getId().equals(id))
                return client;
        }
        return null;
    }

    @Override
    public Client getClientByCompanyName(String companyName) {
        Map<Client, ClientRO> clientMap = MemoryMapRepo.CLIENT_MAP;
        Set<Client> clients = clientMap.keySet();
        for (Client client : clients) {
            if (client.getCompanyName().equals(companyName))
                return client;
        }
        return null;
    }
}
