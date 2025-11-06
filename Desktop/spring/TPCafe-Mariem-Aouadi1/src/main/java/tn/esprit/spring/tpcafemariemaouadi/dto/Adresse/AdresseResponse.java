package tn.esprit.spring.tpcafemariemaouadi.dto.Adresse;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdresseResponse {
    private Long idAdresse;
    private String rue;
    private String ville;
    private int codePostal;
}
