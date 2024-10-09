package com.romain.tp.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.romain.tp.model.Article;
import com.romain.tp.model.User;
import com.romain.tp.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
    private ArticleService articleService;
	
    /**
    * Read - Get all articles
    * @return - An Iterable object of Article full filled
    */
    @GetMapping("/articles")
    public Iterable<Article> getArticles() {
        return articleService.getArticles();
    }
    
	/**
	 * Create - Add a new Article
	 * @param User An object Article
	 * @return The Article object saved
	 */
	@PostMapping("/article")
	public Article createArticle(@RequestBody Article Article) {
		return articleService.saveArticle(Article);
	}
	
	/**
	 * Read - Get one Article 
	 * @param id The id of the Article
	 * @return An Article object full filled
	 */
	@GetMapping("/article/{id}")
	public Article getArticle(@PathVariable final Long id) {
		Optional<Article> Article = articleService.getArticle(id);
		if(Article.isPresent()) {
			return Article.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/articles/{id}")
	public List<Article> getArticlesByUser(@PathVariable final Long id) {
		return articleService.getArticlesByUser(id);
	}

	
	/**
	 * Update - Update an existing User
	 * @param id - The id of the User to update
	 * @param Article - The Article object updated
	 * @return
	 */
	@PutMapping("/articles/{id}")
	public Article updateArticle(@PathVariable final Long id, @RequestBody Article article) {
		Optional<Article> e = articleService.getArticle(id);
		if(e.isPresent()) {
			Article currentArticle = e.get();
			
			String title = article.getTitle();
			if(title != null) {
				currentArticle.setTitle(title);
			}
			String content = article.getContent();
			if(content != null) {
				currentArticle.setContent(content);
			}
			User user = article.getUser();
			if(user != null) {
				currentArticle.setUser(user);;
			}
			Date date = article.getDate();
			if(date != null) {
				currentArticle.setDate(date);;
			}
			articleService.saveArticle(currentArticle);
			return currentArticle;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an User
	 * @param id - The id of the Article to delete
	 */
	@DeleteMapping("/article/{id}")
	public void deleteArticle(@PathVariable final Long id) {
		articleService.deleteArticle(id);
	}
}