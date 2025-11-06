package tn.esprit.spring.tpcafemariemaouadi.services.Client;

import tn.esprit.spring.tpcafemariemaouadi.entities.Client;

import java.util.List;

public interface IClientService {
    Client addClient(Client client);
    List<Client> saveClients(List<Client> clients);
    Client selectClientById(long id);
    Client selectClientByIdWithGet(long id);
    Client selectClientByIdWithOrElse(long id);
    List<Client> selectAllClients();
    void deleteClient(Client client);
    void deleteAllClients();
    void deleteClientById(long id);
    long countClients();
    boolean verifClientById(long id);
}
