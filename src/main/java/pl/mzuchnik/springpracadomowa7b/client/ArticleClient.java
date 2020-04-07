package pl.mzuchnik.springpracadomowa7b.client;

import pl.mzuchnik.springpracadomowa7b.model.Article;

import java.util.List;

public interface ArticleClient {

    List<Article> getTopLineArticles(String language);

}
