package com.shao.mybatislearningdemo.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    /**
     * 保存文章
     */
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }

    /**
     * 根据id查询文章
     */
    public Article findArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    /**
     * 获取所有文章
     */
    public Iterable<Article> findAllArticle() {
        return articleMapper.getAllArticles();
    }

    /**
     * 删除文章
     */
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticleById(id);
    }

    /**
     * 修改文章
     */
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
}
