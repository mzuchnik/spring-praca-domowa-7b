package pl.mzuchnik.springpracadomowa7b.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.mzuchnik.springpracadomowa7b.model.Article;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addArticle(Article article) {
        String sql = "INSERT INTO articles VALUES(?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(
                sql,
                article.getId(),
                article.getSource(),
                article.getTitle(),
                article.getDescription(),
                article.getContent(),
                article.getPublishedAt(),
                article.getUrlImage(),
                article.getAuthor());
        return result;
    }

    @Override
    public int updateArticle(Article article) {
        String sql = "UPDATE articles SET source=?, title=?, description=?, content=?, publishedAt=?,`url-image`=?, author=? WHERE id=?";
        int result = jdbcTemplate.update(sql,
                article.getSource(),
                article.getTitle(),
                article.getDescription(),
                article.getContent(),
                article.getPublishedAt(),
                article.getUrlImage(),
                article.getAuthor(),
                article.getId());
        return result;
    }

    @Override
    public List<Article> findAll() {
        String sql = "SELECT * FROM articles";
        RowMapper rowMapper = (rs, i) -> new Article(rs.getLong("id"),rs.getString("source"),rs.getString("title"),rs.getString("description"),rs.getString("content"),rs.getString("publishedAt"),rs.getString("url-image"),rs.getString("author"));
        List<Article> articles = jdbcTemplate.query(sql, rowMapper);
        return articles;
    }

    @Override
    public int removeArticle(long id) {
        String sql = "DELETE FROM articles WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }
}
