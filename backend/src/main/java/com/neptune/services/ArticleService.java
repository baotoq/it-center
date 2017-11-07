package com.neptune.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.neptune.entities.Article;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {

    @PersistenceContext
    private EntityManager entityManager;

    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    public List<Article> getAllArticles() {
        String sql = "FROM Article as atcl ORDER BY atcl.id DESC";
        return (List<Article>) entityManager.createQuery(sql).getResultList();
    }

    public void createArticle(Article article) {
        entityManager.persist(article);
    }

    public void updateArticle(Article article) {
        Article artcl = getArticleById(article.getId());
        artcl.setTitle(article.getTitle());
        artcl.setCategory(article.getCategory());
        entityManager.flush();
    }

    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    public boolean articleExists(String title, String category) {
        String sql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(sql).setParameter(1, title)
                .setParameter(2, category).getResultList().size();
        return count > 0;
    }
}
