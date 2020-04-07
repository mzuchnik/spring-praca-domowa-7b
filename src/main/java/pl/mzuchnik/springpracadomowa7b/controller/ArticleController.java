package pl.mzuchnik.springpracadomowa7b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mzuchnik.springpracadomowa7b.client.ArticleClient;
import pl.mzuchnik.springpracadomowa7b.dao.ArticleDao;
import pl.mzuchnik.springpracadomowa7b.model.Article;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private ArticleClient articleClient;
    private ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleClient articleClient, ArticleDao articleDao) {
        this.articleClient = articleClient;
        this.articleDao = articleDao;
    }


    @GetMapping
    public String getAllArticles(Model model, @RequestParam(defaultValue = "pl") String country)
    {

        model.addAttribute("articles",articleClient.getTopLineArticles(country));
        return "articles";
    }

    @PostMapping
    public String saveArticle(@ModelAttribute Article article)
    {
        articleDao.addArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/saved")
    public String getSavedArticles(Model model)
    {
        model.addAttribute("articles",articleDao.findAll());
        return "savedArticles";
    }
    @GetMapping("/update")
    public String updateArticle(@ModelAttribute Article article)
    {
        System.out.println(article);
        articleDao.updateArticle(article);
        return "redirect:/articles/saved";
    }
    @GetMapping("/remove")
    public String removeArticle(@RequestParam long id)
    {
        articleDao.removeArticle(id);
        return "redirect:/articles/saved";
    }



}
