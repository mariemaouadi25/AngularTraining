package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafemariemaouadi.services.Adresse.IAdressseService;


@RestController
@AllArgsConstructor
@RequestMapping("/api/adresses")
public class AdresseRestController {

 IAdressseService iAdresseService;

    // ➕ Ajouter une adresse
    @PostMapping
    public AdresseResponse addAdresse(@RequestBody AdresseRequest adresseRequest) {
        return iAdresseService.addAdresse(adresseRequest);
    }

    // 🔍 Récupérer une adresse par ID
    @GetMapping("/{id}")
    public AdresseResponse getAdresseById(@PathVariable long id) {
        return iAdresseService.getAdresseById(id);
    }

    // 🗑️ Supprimer une adresse par ID
    @DeleteMapping("/{id}")
    public void deleteAdresseById(@PathVariable long id) {
        iAdresseService.deleteAdresseById(id);
    }

    // 🧹 Supprimer toutes les adresses
    @DeleteMapping
    public void deleteAllAdresses() {
        iAdresseService.deleteAllAdresses();
    }

    // 🔢 Compter toutes les adresses
    @GetMapping("/count")
    public long countAdresses() {
        return iAdresseService.countAdresses();
    }

    // ✅ Vérifier si une adresse existe
    @GetMapping("/exists/{id}")
    public boolean verifAdresseById(@PathVariable long id) {
        return iAdresseService.verifAdresseById(id);
    }
}
