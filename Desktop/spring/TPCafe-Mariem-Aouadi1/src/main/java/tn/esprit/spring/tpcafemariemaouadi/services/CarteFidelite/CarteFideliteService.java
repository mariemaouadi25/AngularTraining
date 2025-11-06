package tn.esprit.spring.tpcafemariemaouadi.services.CarteFidelite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemariemaouadi.entities.CarteFidelite;
import tn.esprit.spring.tpcafemariemaouadi.repositories.CarteFideliteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CarteFideliteService implements ICarteFideliteService {

    private final CarteFideliteRepository carteFideliteRepository;

    // ===== Basic CRUD =====
    @Override
    public CarteFidelite addCarteFidelite(CarteFidelite carte) {
        return carteFideliteRepository.save(carte);
    }

    @Override
    public List<CarteFidelite> saveCartesFidelite(List<CarteFidelite> cartes) {
        return carteFideliteRepository.saveAll(cartes);
    }

    @Override
    public CarteFidelite selectCarteById(long id) {
        return carteFideliteRepository.findById(id).orElse(null);
    }

    @Override
    public List<CarteFidelite> selectAllCartes() {
        return carteFideliteRepository.findAll();
    }

    @Override
    public void deleteCarte(CarteFidelite carte) {
        carteFideliteRepository.delete(carte);
    }

    @Override
    public void deleteAllCartes() {
        carteFideliteRepository.deleteAll();
    }

    @Override
    public void deleteCarteById(long id) {
        carteFideliteRepository.deleteById(id);
    }

    @Override
    public long countCartes() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifCarteById(long id) {
        return carteFideliteRepository.existsById(id);
    }

    // ===== With Optional Handling =====
    @Override
    public CarteFidelite selectCarteByIdWithOrElse(long id) {
        CarteFidelite defaultCarte = CarteFidelite.builder()
                .pointsAccumules(0)
                .dateCreation(LocalDate.now())
                .build();
        return carteFideliteRepository.findById(id).orElse(defaultCarte);
    }

    @Override
    public CarteFidelite selectCarteByIdWithGet(long id) {
        return carteFideliteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CarteFidelite not found with id: " + id));
    }

    // ===== New methods from interface =====
    @Override
    public List<CarteFidelite> selectAllCartesFidelite() {
        return carteFideliteRepository.findAll();
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithOrElse(long id) {
        return selectCarteByIdWithOrElse(id);
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithGet(long id) {
        return selectCarteByIdWithGet(id);
    }

    @Override
    public void deleteCarteFideliteById(long id) {
        deleteCarteById(id);
    }

    @Override
    public void deleteAllCartesFidelite() {
        deleteAllCartes();
    }

    @Override
    public long countCartesFidelite() {
        return countCartes();
    }

    @Override
    public boolean verifCarteFideliteById(long id) {
        return verifCarteById(id);
    }
}
