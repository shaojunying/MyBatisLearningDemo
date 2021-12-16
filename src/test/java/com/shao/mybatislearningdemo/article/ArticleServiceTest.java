package com.shao.mybatislearningdemo.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @Mock ArticleMapper articleMapper;

    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        articleService = new ArticleService(articleMapper);
    }

    @Test
    void saveArticle() {
        Article article = new Article("title", "content");
        articleService.saveArticle(article);
        verify(articleMapper).saveArticle(any(Article.class));
    }

    @Test
    void findArticleById() {
        articleService.findArticleById(1);
        verify(articleMapper).getArticleById(any(Integer.class));
    }

    @Test
    void findAllArticle() {
        articleService.findAllArticle();
        verify(articleMapper).getAllArticles();
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(1);
        verify(articleMapper).deleteArticleById(any(Integer.class));
    }

    @Test
    void updateArticle() {
        Article article = new Article("title", "content");
        articleService.updateArticle(article);
        verify(articleMapper).updateArticle(any(Article.class));
    }
}
