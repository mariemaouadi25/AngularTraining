package tn.esprit.spring.tpcafemariemaouadi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPromotion;

    // ✅ String comme dans le diagramme
    @Column(name = "pourcentage_promo")
    private String pourcentagePromo;

    private LocalDate dateDebutPromo;
    private LocalDate dateFinPromo;

    // ✅ AJOUTER - Relation avec Article (1 Promotion → 1 Article)
    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;

}