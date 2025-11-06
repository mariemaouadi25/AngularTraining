package tn.esprit.spring.tpcafemariemaouadi.services.Commande;

import tn.esprit.spring.tpcafemariemaouadi.entities.Commande;

import java.util.List;

public interface ICommandeService {

    Commande addCommande(Commande commande);


    Commande selectCommandeById(long id);

    Commande selectCommandeByIdWithGet(long id);

    Commande selectCommandeByIdWithOrElse(long id);

    List<Commande> selectAllCommandes();

    void deleteCommande(Commande commande);

    void deleteAllCommandes();

    void deleteCommandeById(long id);

    long countCommandes();

    boolean verifCommandeById(long id);

    List<Commande> saveCommande(List<Commande> commande);
}
