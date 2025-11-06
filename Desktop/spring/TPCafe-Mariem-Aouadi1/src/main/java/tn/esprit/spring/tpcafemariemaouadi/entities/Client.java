package tn.esprit.spring.tpcafemariemaouadi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    // ✅ Relation 1-1 avec Adresse
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    // ✅ Relation 1-1 avec CarteFidelite (PARENT)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carte_fidelite")
    private CarteFidelite carteFidelite;

    // ✅ Relation 1-M avec Commande
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;
}