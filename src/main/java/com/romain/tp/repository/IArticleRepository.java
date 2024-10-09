package com.romain.tp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.romain.tp.model.Article;

public interface IArticleRepository extends JpaRepository<Article, Long> {
	@EntityGraph(attributePaths = {"user"})
	List<Article> findByUserId(Long userId);
}

