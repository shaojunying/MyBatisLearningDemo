package com.shao.mybatislearningdemo.article;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void saveArticle() {
        // given
        Article article = new Article(
                "My Test Article",
                "This is a test article");
        // when
        int lines = articleMapper.saveArticle(article);

        // then
        assertEquals(1, lines);
        assertNotNull(article.getId());
    }

    @Test
    void getArticleByIdWhenExists() {
        // given
        Article article = new Article(
                "My Another Test Article",
                "This is a test article");
        articleMapper.saveArticle(article);
        // when
        Article queriedArticle = articleMapper.getArticleById(article.getId());
        // then
        assertEquals(article.getTitle(), queriedArticle.getTitle());
    }

    @Test
    void getArticleByIdWhenNotExists() {
        // given
        // when
        Article queriedArticle = articleMapper.getArticleById(255);
        // then
        assertNull(queriedArticle);
    }

    @Test
    void getAllArticles() {
        // given

        // when
        List<Article> articles = articleMapper.getAllArticles();

        // then
        assertTrue(articles.size() > 0);
    }

    @Test
    void deleteArticleById() {
        // given
        Article article = new Article(
                "My Another Test Article",
                "This is a test article");
        articleMapper.saveArticle(article);
        // when
        int lines = articleMapper.deleteArticleById(article.getId());
        // then
        assertEquals(1, lines);
    }

    @Test
    void updateArticle() {
        // given
        Article article = new Article(
                "My Another Test Article",
                "This is a test article");
        articleMapper.saveArticle(article);
        // when
        article.setTitle("My Updated Test Article");
        article.setContent("This is a updated test article");
        int lines = articleMapper.updateArticle(article);
        // then
        assertEquals(1, lines);
    }
}
