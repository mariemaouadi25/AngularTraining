package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.entities.Client;
import tn.esprit.spring.tpcafemariemaouadi.services.Client.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientRestController {

    private IClientService clientService;

    @GetMapping
    public List<Client> selectAllClients() {
        return clientService.selectAllClients();
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PostMapping("addclient")
    public List<Client> addClient(@RequestBody List<Client> client) {
        return clientService.saveClients(client);
    }

    @GetMapping("selectById/{id}")
    public Client selectById(@PathVariable long id) {
        return clientService.selectClientByIdWithGet(id);
    }

    @GetMapping("selectById2")
    public Client selectById2(@RequestParam long id) {
        return clientService.selectClientByIdWithOrElse(id);
    }

    @DeleteMapping("deletebyid/{id}")
    public void deleteClientById(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllClients() {
        clientService.deleteAllClients();
    }

    @GetMapping("count")
    public long countClients() {
        return clientService.countClients();
    }

    @GetMapping("exists/{id}")
    public boolean verifClientById(@PathVariable long id) {
        return clientService.verifClientById(id);
    }
}
