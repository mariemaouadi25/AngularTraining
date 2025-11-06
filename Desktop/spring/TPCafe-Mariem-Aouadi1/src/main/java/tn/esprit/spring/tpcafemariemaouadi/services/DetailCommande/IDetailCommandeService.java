package tn.esprit.spring.tpcafemariemaouadi.services.DetailCommande;

import tn.esprit.spring.tpcafemariemaouadi.entities.DetailCommande;
import java.util.List;

public interface IDetailCommandeService {

    // Ajouter un seul détail
    DetailCommande addDetailCommande(DetailCommande detail);

    // Ajouter plusieurs détails
    List<DetailCommande> saveDetailCommandes(List<DetailCommande> details);

    // Ajouter plusieurs détails
    List<DetailCommande> saveDetailsCommande(List<DetailCommande> details);

    // Récupérer un détail par id
    DetailCommande selectDetailCommandeById(long id);

    DetailCommande selectDetailCommandeByIdWithGet(long id);

    DetailCommande selectDetailCommandeByIdWithOrElse(long id);

    // Récupérer tous les détails
    List<DetailCommande> selectAllDetailCommandes();

    // Récupérer un détail par id
    DetailCommande selectDetailCommandeById(Long id);

    // Supprimer un détail par id
    void deleteDetailCommandeById(Long id);

    // Supprimer un détail
    void deleteDetailCommande(DetailCommande detail);

    // Supprimer tous les détails
    void deleteAllDetailCommandes();

    // Supprimer par id
    void deleteDetailCommandeById(long id);

    // Compter tous les détails
    long countDetailCommandes();

    // Vérifier l’existence par id
    boolean verifDetailCommandeById(long id);
}
