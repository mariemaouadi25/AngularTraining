package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.entities.Promotion;
import tn.esprit.spring.tpcafemariemaouadi.services.Promotion.PromotionService;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@AllArgsConstructor
public class PromotionRestController {

    private final PromotionService promotionService;

    // ✅ Ajouter une seule promotion
    @PostMapping
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        return promotionService.addPromotion(promotion);
    }

    // ✅ Ajouter plusieurs promotions
    @PostMapping("/addpromotions")
    public List<Promotion> addPromotions(@RequestBody List<Promotion> promotions) {
        return promotionService.savePromotions(promotions);
    }

    // ✅ Récupérer toutes les promotions
    @GetMapping
    public List<Promotion> selectAllPromotions() {
        return promotionService.selectAllPromotions();
    }

    // ✅ Récupérer une promotion par id
    @GetMapping("/{id}")
    public Promotion selectPromotionById(@PathVariable Long id) {
        return promotionService.selectPromotionByIdWithGet(id);
    }

    // ✅ Récupérer une promotion avec valeur par défaut si non trouvée
    @GetMapping("/orElse/{id}")
    public Promotion selectPromotionByIdOrElse(@PathVariable Long id) {
        return promotionService.selectPromotionByIdWithOrElse(id);
    }

    // ✅ Supprimer une promotion par id
    @DeleteMapping("/delete/{id}")
    public void deletePromotionById(@PathVariable Long id) {
        promotionService.deletePromotionById(id);
    }

    // ✅ Supprimer toutes les promotions
    @DeleteMapping("/deleteAll")
    public void deleteAllPromotions() {
        promotionService.deleteAllPromotions();
    }

    // ✅ Compter toutes les promotions
    @GetMapping("/count")
    public long countPromotions() {
        return promotionService.countPromotions();
    }

    // ✅ Vérifier si une promotion existe par id
    @GetMapping("/exists/{id}")
    public boolean verifPromotionById(@PathVariable Long id) {
        return promotionService.verifPromotionById(id);
    }
}
