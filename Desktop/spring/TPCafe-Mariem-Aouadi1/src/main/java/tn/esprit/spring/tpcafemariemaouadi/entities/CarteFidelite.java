package tn.esprit.spring.tpcafemariemaouadi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "carte_fidelite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarteFidelite;

    private int pointsAccumules;
    private LocalDate dateCreation;

    // ✅ Relation inverse 1-1 avec Client
    @OneToOne(mappedBy = "carteFidelite")
    private Client client;
}
