package com.shao.mybatislearningdemo.article;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article(title, content) values(#{title}, #{content})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int saveArticle(Article article);

    @Select("select * from article where id = #{id}")
    Article getArticleById(Integer id);

    @Select("select * from article")
    List<Article> getAllArticles();

    @Delete("delete from article where id = #{id}")
    int deleteArticleById(Integer id);

    @Update("update article set title = #{title}, content = #{content} where id = #{id}")
    int updateArticle(Article article);
}
