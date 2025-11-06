package tn.esprit.spring.tpcafemariemaouadi.services.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemariemaouadi.entities.Article;
import tn.esprit.spring.tpcafemariemaouadi.repositories.ArticleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    @Override
    public Article selectArticleById(long id) {
        return articleRepository.findById((long) id).orElse(null);
    }

    @Override
    public Article selectArticleByIdWithGet(long id) {
        return articleRepository.findById((long) id).get();
    }

    @Override
    public Article selectArticleByIdWithOrElse(long id) {
        Article article = Article.builder()
                .nomArticle("Article par défaut")
                .prixArticle(0)
                .build();
        return articleRepository.findById(id).orElse(article);
    }

    @Override
    public List<Article> selectAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public long countArticles() {
        return articleRepository.count();
    }

    @Override
    public boolean verifArticleById(long id) {
        return articleRepository.existsById(id);
    }
}

