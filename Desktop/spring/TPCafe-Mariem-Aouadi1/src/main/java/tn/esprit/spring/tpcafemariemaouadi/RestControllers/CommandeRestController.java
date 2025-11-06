package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.entities.Article;
import tn.esprit.spring.tpcafemariemaouadi.entities.Commande;
import tn.esprit.spring.tpcafemariemaouadi.services.Commande.ICommandeService;

import java.util.List;

@RestController
@RequestMapping("/commande")
@AllArgsConstructor
public class CommandeRestController {

    private ICommandeService commandeService;

    @GetMapping
    public List<Commande> selectAllCommandes() {
        return commandeService.selectAllCommandes();
    }

    @PostMapping
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }

    @PostMapping("addcommande")
    public List<Commande> addCommande(@RequestBody List<Commande> commandes) {
        return commandeService.saveCommande(commandes);
    }


    @GetMapping("selectById/{id}")
    public Commande selectById(@PathVariable long id) {
        return commandeService.selectCommandeByIdWithGet(id);
    }

    @GetMapping("selectById2")
    public Commande selectById2(@RequestParam long id) {
        return commandeService.selectCommandeByIdWithOrElse(id);
    }

    @DeleteMapping("deletebyid/{id}")
    public void deleteCommandeById(@PathVariable long id) {
        commandeService.deleteCommandeById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllCommandes() {
        commandeService.deleteAllCommandes();
    }

    @GetMapping("count")
    public long countCommandes() {
        return commandeService.countCommandes();
    }

    @GetMapping("exists/{id}")
    public boolean verifCommandeById(@PathVariable long id) {
        return commandeService.verifCommandeById(id);
    }
}
