package com.shao.mybatislearningdemo.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ArticleControllerTest {

    @Mock ArticleService articleService;
    private ArticleController articleController;

    @BeforeEach
    void setUp() {
        articleController = new ArticleController(articleService);
    }

    @Test
    void save() {
        Article article = new Article("title", "content");
        articleController.save(article);
        verify(articleService).saveArticle(article);
    }

    @Test
    void findById() {
        articleController.findById(1);
        verify(articleService).findArticleById(1);
    }

    @Test
    void findAll() {
        articleController.findAll();
        verify(articleService).findAllArticle();
    }

    @Test
    void delete() {
        articleController.delete(1);
        verify(articleService).deleteArticle(1);
    }

    @Test
    void update() {
        Article article = new Article("title", "content");
        articleController.update(article);
        verify(articleService).updateArticle(article);
    }
}
