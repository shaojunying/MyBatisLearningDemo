package com.shao.mybatislearningdemo.article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {

    private final ArticleService userService;

    @Autowired
    public ArticleController(ArticleService userService) {
        this.userService = userService;
    }

    /**
     * 保存文章
     */
    @PostMapping("save")
    public void save(Article article) {
        userService.saveArticle(article);
    }

    /**
     * 根据id查询文章
     */
    @GetMapping("findById")
    public Article findById(Integer id) {
        return userService.findArticleById(id);
    }

    /**
     * 获取所有文章
     */
    @GetMapping("findAll")
    public Iterable<Article> findAll() {
        return userService.findAllArticle();
    }

    /**
     * 删除文章
     */
    @PostMapping("delete")
    public void delete(Integer id) {
        userService.deleteArticle(id);
    }

    /**
     * 修改文章
     */
    @PostMapping("update")
    public void update(Article article) {
        userService.updateArticle(article);
    }

}
