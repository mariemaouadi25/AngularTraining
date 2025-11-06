package tn.esprit.spring.tpcafemariemaouadi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemariemaouadi.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
