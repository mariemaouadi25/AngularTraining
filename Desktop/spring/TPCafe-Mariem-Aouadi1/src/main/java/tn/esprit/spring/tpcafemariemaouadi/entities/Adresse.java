package tn.esprit.spring.tpcafemariemaouadi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "adresse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdresse;

    private String rue;
    private String ville;

    @Column(name = "code_postal")
    private int codePostal;

    // ✅ Relation inverse avec Client
    @OneToOne(mappedBy = "adresse")
    private Client client;
}
