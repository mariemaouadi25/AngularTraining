package tn.esprit.spring.tpcafemariemaouadi.services.Adresse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafemariemaouadi.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafemariemaouadi.entities.Adresse;
import tn.esprit.spring.tpcafemariemaouadi.mapper.AdresseMapper;
import tn.esprit.spring.tpcafemariemaouadi.repositories.AdresseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdresseService implements IAdressseService {

    private final AdresseRepository adresseRepository;
    private final AdresseMapper adresseMapper;

    // ➕ Ajouter une adresse
    @Override
    public AdresseResponse addAdresse(AdresseRequest request) {
        Adresse adresse = adresseMapper.toEntity(request);
        Adresse saved = adresseRepository.save(adresse);
        return adresseMapper.toDto(saved);
    }

    // 🔍 Récupérer une adresse par ID
    @Override
    public AdresseResponse getAdresseById(long id) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse non trouvée"));
        return adresseMapper.toDto(adresse);
    }

    // 🗑️ Supprimer une adresse par ID
    @Override
    public void deleteAdresseById(long id) {
        adresseRepository.deleteById(id);
    }

    // 🧹 Supprimer toutes les adresses
    @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();
    }

    // 🔢 Compter les adresses
    @Override
    public long countAdresses() {
        return adresseRepository.count();
    }

    // ✅ Vérifier si une adresse existe
    @Override
    public boolean verifAdresseById(long id) {
        return adresseRepository.existsById(id);
    }

    // 📋 (Optionnel) Récupérer toutes les adresses
    public List<AdresseResponse> getAllAdresses() {
        return adresseRepository.findAll()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }
}
