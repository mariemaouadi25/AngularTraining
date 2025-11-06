package tn.esprit.spring.tpcafemariemaouadi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemariemaouadi.entities.DetailCommande;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande,Long> {
}
