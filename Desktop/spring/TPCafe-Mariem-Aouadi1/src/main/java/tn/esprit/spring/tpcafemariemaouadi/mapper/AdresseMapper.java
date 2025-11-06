package tn.esprit.spring.tpcafemariemaouadi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafemariemaouadi.entities.Adresse;

@Component
public class AdresseMapper {

    public Adresse toEntity(AdresseRequest request) {
        return Adresse.builder()
                .rue(request.getRue())
                .ville(request.getVille())
                .codePostal(request.getCodePostal())
                .build();
    }

    public AdresseResponse toDto(Adresse adresse) {
        return AdresseResponse.builder()
                .idAdresse(adresse.getIdAdresse())
                .rue(adresse.getRue())
                .ville(adresse.getVille())
                .codePostal(adresse.getCodePostal())
                .build();
    }
}
