package pl.mzuchnik.springpracadomowa7b.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.mzuchnik.springpracadomowa7b.model.Article;
import pl.mzuchnik.springpracadomowa7b.model.api.ArticleApiFullResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleClientImpl implements ArticleClient {

    private RestTemplate restTemplate;

    @Value("${newsapi-url}")
    private String apiUrl;

    @Value("${newsapi-key}")
    private String apiKey;

    public ArticleClientImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public List<Article> getTopLineArticles(String country) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-api-key", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("country", country);

        ArticleApiFullResponse body = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(null, httpHeaders),
                ArticleApiFullResponse.class)
                .getBody();

        return getArticles(body);
    }

    private List<Article> getArticles(ArticleApiFullResponse body) {
        List<Article> articles = new ArrayList<>();

        body.getArticles().stream()
                .forEach(a -> {
                    articles.add(new Article(0,
                            a.getSource().getName(),
                            a.getTitle(),
                            a.getDescription(),
                            a.getContent(),
                            a.getPublishedAt(),
                            a.getUrlToImage(),
                            a.getAuthor()));
                });
        return articles;
    }
}
