package tn.esprit.spring.tpcafemariemaouadi.services.DetailCommande;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemariemaouadi.entities.DetailCommande;
import tn.esprit.spring.tpcafemariemaouadi.repositories.DetailCommandeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailCommandeService implements IDetailCommandeService {

    private final DetailCommandeRepository detailCommandeRepository;

    // Ajouter un seul détail
    @Override
    public DetailCommande addDetailCommande(DetailCommande detail) {
        return detailCommandeRepository.save(detail);
    }

    @Override
    public List<DetailCommande> saveDetailCommandes(List<DetailCommande> details) {
        return List.of();
    }

    // Ajouter plusieurs détails
    @Override
    public List<DetailCommande> saveDetailsCommande(List<DetailCommande> details) {
        return detailCommandeRepository.saveAll(details);
    }

    // Récupérer un détail par id
    @Override
    public DetailCommande selectDetailCommandeById(long id) {
        return detailCommandeRepository.findById(id).orElse(null);
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithGet(long id) {
        return detailCommandeRepository.findById(id).get();
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithOrElse(long id) {
        DetailCommande defaultDetail = DetailCommande.builder()
                .quantiteArticle(0)
                .sousTotalDetailArticle(0f)
                .sousTotalDetailArticleApresPromo(0f)
                .build();
        return detailCommandeRepository.findById(id).orElse(defaultDetail);
    }

    // Récupérer tous les détails
    @Override
    public List<DetailCommande> selectAllDetailCommandes() {
        return detailCommandeRepository.findAll();
    }

    @Override
    public DetailCommande selectDetailCommandeById(Long id) {
        return null;
    }

    @Override
    public void deleteDetailCommandeById(Long id) {

    }

    // Supprimer un détail
    @Override
    public void deleteDetailCommande(DetailCommande detail) {
        detailCommandeRepository.delete(detail);
    }

    // Supprimer tous les détails
    @Override
    public void deleteAllDetailCommandes() {
        detailCommandeRepository.deleteAll();
    }

    // Supprimer par id
    @Override
    public void deleteDetailCommandeById(long id) {
        detailCommandeRepository.deleteById(id);
    }

    // Compter tous les détails
    @Override
    public long countDetailCommandes() {
        return detailCommandeRepository.count();
    }

    // Vérifier l’existence par id
    @Override
    public boolean verifDetailCommandeById(long id) {
        return detailCommandeRepository.existsById(id);
    }
}
