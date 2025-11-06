package tn.esprit.spring.tpcafemariemaouadi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "detail_commande")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailCommande;

    private int quantiteArticle;
    private float sousTotalDetailArticle;
    private float sousTotalDetailArticleApresPromo;

    @ManyToOne
    @JoinColumn(name = "idCommande")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

}
