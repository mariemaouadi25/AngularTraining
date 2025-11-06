package tn.esprit.spring.tpcafemariemaouadi.services.Client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemariemaouadi.entities.Client;
import tn.esprit.spring.tpcafemariemaouadi.repositories.ClientRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> saveClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    @Override
    public Client selectClientById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client selectClientByIdWithGet(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client selectClientByIdWithOrElse(long id) {
        Client defaultClient = Client.builder()
                .nom("Nom par défaut")
                .prenom("Prénom par défaut")
                .build();
        return clientRepository.findById(id).orElse(defaultClient);
    }

    @Override
    public List<Client> selectAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public long countClients() {
        return clientRepository.count();
    }

    @Override
    public boolean verifClientById(long id) {
        return clientRepository.existsById(id);
    }
}