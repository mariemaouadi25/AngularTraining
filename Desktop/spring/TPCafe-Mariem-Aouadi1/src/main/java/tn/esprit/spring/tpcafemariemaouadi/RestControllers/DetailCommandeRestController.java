package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.entities.DetailCommande;
import tn.esprit.spring.tpcafemariemaouadi.services.DetailCommande.DetailCommandeService;

import java.util.List;
@RestController
@RequestMapping("/detailcommande")
@AllArgsConstructor
public class DetailCommandeRestController {

    private final DetailCommandeService detailCommandeService;

    // ✅ Ajouter un seul détail
    @PostMapping
    public DetailCommande addDetailCommande(@RequestBody DetailCommande detailCommande) {
        return detailCommandeService.addDetailCommande(detailCommande);
    }

    // ✅ Ajouter plusieurs détails
    @PostMapping("/adddetailcommande")
    public List<DetailCommande> addDetailCommandes(@RequestBody List<DetailCommande> details) {
        return detailCommandeService.saveDetailCommandes(details);
    }

    // ✅ Récupérer tous les détails
    @GetMapping
    public List<DetailCommande> selectAllDetailCommandes() {
        return detailCommandeService.selectAllDetailCommandes();
    }

    // ✅ Récupérer un détail par id
    @GetMapping("/{id}")
    public DetailCommande selectDetailCommandeById(@PathVariable Long id) {
        return detailCommandeService.selectDetailCommandeById(id);
    }

    // ✅ Supprimer un détail par id
    @DeleteMapping("/delete/{id}")
    public void deleteDetailCommandeById(@PathVariable Long id) {
        detailCommandeService.deleteDetailCommandeById(id);
    }
}
