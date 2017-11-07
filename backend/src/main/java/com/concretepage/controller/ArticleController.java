package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Article;
import com.concretepage.service.ArticleService;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("article")
    public ResponseEntity<Article> getArticleById(@RequestParam("id") String id) {
        Article article = articleService.getArticleById(Integer.parseInt(id));
        return new ResponseEntity(article, HttpStatus.OK);
    }

    @GetMapping("all-articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> list = articleService.getAllArticles();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("article")
    public ResponseEntity<Void> createArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        if (articleService.articleExists(article.getTitle(), article.getCategory())) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        } else {
            articleService.createArticle(article);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getArticleId()).toUri());
            return new ResponseEntity(headers, HttpStatus.CREATED);
        }
    }

    @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity(article, HttpStatus.OK);
    }

    @DeleteMapping("article")
    public ResponseEntity<Void> deleteArticle(@RequestParam("id") String id) {
        articleService.deleteArticle(Integer.parseInt(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
