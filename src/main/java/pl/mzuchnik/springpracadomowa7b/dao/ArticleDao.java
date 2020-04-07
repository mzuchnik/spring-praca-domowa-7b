package pl.mzuchnik.springpracadomowa7b.dao;

import pl.mzuchnik.springpracadomowa7b.model.Article;

import java.util.List;

public interface ArticleDao {


    int addArticle(Article article);

    int updateArticle(Article article);

    List<Article> findAll();

    int removeArticle(long id);
}
