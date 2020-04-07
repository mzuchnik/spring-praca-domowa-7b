package pl.mzuchnik.springpracadomowa7b.model;

public class Article {

  private long id;
  private String source;
  private String title;
  private String description;
  private String content;
  private String publishedAt;
  private String urlImage;
  private String author;

  public Article() {
  }

  public Article(String source, String title, String description, String content, String publishedAt, String urlImage, String author) {
    this.source = source;
    this.title = title;
    this.description = description;
    this.content = content;
    this.publishedAt = publishedAt;
    this.urlImage = urlImage;
    this.author = author;
  }

  public Article(long id, String source, String title, String description, String content, String publishedAt, String urlImage, String author) {
    this.id = id;
    this.source = source;
    this.title = title;
    this.description = description;
    this.content = content;
    this.publishedAt = publishedAt;
    this.urlImage = urlImage;
    this.author = author;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
  }


  public String getUrlImage() {
    return urlImage;
  }

  public void setUrlImage(String urlImage) {
    this.urlImage = urlImage;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Article{" +
            "id=" + id +
            ", source='" + source + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", content='" + content + '\'' +
            ", publishedAt='" + publishedAt + '\'' +
            ", urlImage='" + urlImage + '\'' +
            ", author='" + author + '\'' +
            '}';
  }
}
