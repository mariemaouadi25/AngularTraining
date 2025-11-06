package tn.esprit.spring.tpcafemariemaouadi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemariemaouadi.entities.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
