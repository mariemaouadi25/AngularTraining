package tn.esprit.spring.tpcafemariemaouadi.services.CarteFidelite;

import tn.esprit.spring.tpcafemariemaouadi.entities.CarteFidelite;

import java.util.List;

public interface ICarteFideliteService {
    CarteFidelite addCarteFidelite(CarteFidelite carte);
    List<CarteFidelite> saveCartesFidelite(List<CarteFidelite> cartes);
    CarteFidelite selectCarteById(long id);
    List<CarteFidelite> selectAllCartes();
    void deleteCarte(CarteFidelite carte);
    void deleteAllCartes();
    void deleteCarteById(long id);
    long countCartes();
    boolean verifCarteById(long id);
    CarteFidelite selectCarteByIdWithOrElse(long id);
    CarteFidelite selectCarteByIdWithGet(long id);

    List<CarteFidelite> selectAllCartesFidelite();

    CarteFidelite selectCarteFideliteByIdWithOrElse(long id);

    CarteFidelite selectCarteFideliteByIdWithGet(long id);

    void deleteCarteFideliteById(long id);

    void deleteAllCartesFidelite();

    long countCartesFidelite();

    boolean verifCarteFideliteById(long id);
}
