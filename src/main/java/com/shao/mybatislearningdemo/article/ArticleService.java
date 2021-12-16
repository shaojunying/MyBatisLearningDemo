package com.shao.mybatislearningdemo.article;

import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ArticleService {

    /**
     * 保存文章
     */
    public void saveArticle(Article article) {
        System.out.println("保存文章");
    }

    /**
     * 根据id查询文章
     */
    public Article findArticleById(Integer id) {
        System.out.println("根据id查询文章");
        return new Article("test", "test");
    }

    /**
     * 获取所有文章
     */
    public Iterable<Article> findAllArticle() {
        System.out.println("获取所有文章");
        return Collections.emptyList();
    }

    /**
     * 删除文章
     */
    public void deleteArticle(Integer id) {
        System.out.println("删除文章");
    }

    /**
     * 修改文章
     */
    public void updateArticle(Article article) {
        System.out.println("修改文章");
    }
}
