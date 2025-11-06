package tn.esprit.spring.tpcafemariemaouadi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commande")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande") // ✅ mapping correct
    Long idCommande;

    @Column(name = "date_commande") // ✅
    LocalDate dateCommande;

    @Column(name = "total_commande") // ✅
    float totalCommande;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_commande") // ✅
    StatusCommande statusCommande;

    @ManyToOne
    @JoinColumn(name = "id_client") // ✅
    Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    List<DetailCommande> details;
}