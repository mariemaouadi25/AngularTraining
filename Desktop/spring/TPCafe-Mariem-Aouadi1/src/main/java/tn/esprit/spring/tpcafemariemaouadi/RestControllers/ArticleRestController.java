package tn.esprit.spring.tpcafemariemaouadi.RestControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemariemaouadi.entities.Article;
import tn.esprit.spring.tpcafemariemaouadi.services.Article.IArticleService;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestController {

    private final IArticleService articleService; // Must be final for @RequiredArgsConstructor

    // Get all articles
    @GetMapping("/all")
    public List<Article> selectAllArticles() {
        return articleService.selectAllArticles();
    }
    @PostMapping("/addarticle")
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }


    // Get article by ID
    @GetMapping("/selectById/{id}")
    public Article selectById(@PathVariable long id) {
        return articleService.selectArticleByIdWithGet(id);
    }

    // Get article by ID with default if not found
    @GetMapping("/selectById2")
    public Article selectById2(@RequestParam long id) {
        return articleService.selectArticleByIdWithOrElse(id);
    }

    // Delete article by ID
    @DeleteMapping("/deletebyid/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

    // Delete all articles
    @DeleteMapping("/deleteAll")
    public void deleteAllArticles() {
        articleService.deleteAllArticles();
    }

    // Count articles
    @GetMapping("/count")
    public long countArticles() {
        return articleService.countArticles();
    }

    // Check if article exists
    @GetMapping("/exists/{id}")
    public boolean verifArticleById(@PathVariable long id) {
        return articleService.verifArticleById(id);
    }
}
