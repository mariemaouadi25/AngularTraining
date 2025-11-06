package tn.esprit.spring.tpcafemariemaouadi.services.Adresse;

import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseResponse;

public interface IAdressseService {
    AdresseResponse addAdresse(AdresseRequest request);
    AdresseResponse getAdresseById(long id);
    void deleteAdresseById(long id);
    void deleteAllAdresses();
    long countAdresses();
    boolean verifAdresseById(long id);
}
