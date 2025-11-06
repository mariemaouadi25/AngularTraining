package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.entities.CarteFidelite;
import tn.esprit.spring.tpcafemariemaouadi.services.CarteFidelite.ICarteFideliteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cartefidelite")
@AllArgsConstructor
public class CarteFideliteRestController {

    private ICarteFideliteService carteFideliteService;

    @GetMapping
    public List<CarteFidelite> selectAllCartesFidelite() {
        return carteFideliteService.selectAllCartesFidelite();
    }

    @PostMapping
    public CarteFidelite addCarteFidelite(@RequestBody CarteFidelite carteFidelite) {
        return carteFideliteService.addCarteFidelite(carteFidelite);
    }

    @PostMapping("/addcartefidelite")
    public CarteFidelite addCarte(@RequestBody CarteFidelite carte) {
        if(carte.getDateCreation() == null) {
            carte.setDateCreation(LocalDate.now());
        }
        return carteFideliteService.addCarteFidelite(carte);
    }

    @GetMapping("selectById/{id}")
    public CarteFidelite selectById(@PathVariable long id) {
        return carteFideliteService.selectCarteFideliteByIdWithGet(id);
    }

    @GetMapping("selectById2")
    public CarteFidelite selectById2(@RequestParam long id) {
        return carteFideliteService.selectCarteFideliteByIdWithOrElse(id);
    }

    @DeleteMapping("deletebyid/{id}")
    public void deleteCarteFideliteById(@PathVariable long id) {
        carteFideliteService.deleteCarteFideliteById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllCartesFidelite() {
        carteFideliteService.deleteAllCartesFidelite();
    }

    @GetMapping("count")
    public long countCartesFidelite() {
        return carteFideliteService.countCartesFidelite();
    }

    @GetMapping("exists/{id}")
    public boolean verifCarteFideliteById(@PathVariable long id) {
        return carteFideliteService.verifCarteFideliteById(id);
    }
}
