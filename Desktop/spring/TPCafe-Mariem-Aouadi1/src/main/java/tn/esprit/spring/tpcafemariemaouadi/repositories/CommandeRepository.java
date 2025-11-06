package tn.esprit.spring.tpcafemariemaouadi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemariemaouadi.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
