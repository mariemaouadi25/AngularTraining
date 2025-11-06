package tn.esprit.spring.tpcafemariemaouadi.services.Commande;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemariemaouadi.entities.Commande;
import tn.esprit.spring.tpcafemariemaouadi.repositories.CommandeRepository;
import tn.esprit.spring.tpcafemariemaouadi.services.Client.IClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }



    @Override
    public Commande selectCommandeById(long id) {
        return commandeRepository.findById((long) id).orElse(null);
    }

    @Override
    public Commande selectCommandeByIdWithGet(long id) {
        return commandeRepository.findById((long) id).get();
    }

    @Override
    public Commande selectCommandeByIdWithOrElse(long id) {
        Commande commandeParDefaut = Commande.builder()
                .totalCommande(0)
                .build();
        return commandeRepository.findById((long) id).orElse(commandeParDefaut);
    }

    @Override
    public List<Commande> selectAllCommandes() {return commandeRepository.findAll();}

    @Override
    public void deleteCommande(Commande commande) {commandeRepository.delete(commande);}

    @Override
    public void deleteAllCommandes() {commandeRepository.deleteAll();}

    @Override
    public void deleteCommandeById(long id) {commandeRepository.deleteById((long) id);}

    @Override
    public long countCommandes() {return commandeRepository.count();}

    @Override
    public boolean verifCommandeById(long id) {return commandeRepository.existsById((long) id);}

    @Override
    public List<Commande> saveCommande(List<Commande> commande) {
        return List.of();
    }
}

