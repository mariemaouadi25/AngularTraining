package tn.esprit.spring.tpcafemariemaouadi.services.Promotion;

import tn.esprit.spring.tpcafemariemaouadi.entities.Promotion;

import java.util.List;

public interface IPromtionService {
    Promotion addPromotion(Promotion promotion);
    List<Promotion> savePromotions(List<Promotion> promotions);
    Promotion selectPromotionByIdWithGet(long id);
    Promotion selectPromotionByIdWithOrElse(long id);
    List<Promotion> selectAllPromotions();

    void deletePromotion(Promotion promotion);

    void deleteAllPromotions();
    void deletePromotionById(long id);
    long countPromotions();
    boolean verifPromotionById(long id);

    Promotion selectPromotionById(long id);
}
