package com.tim.mini.gamespot.articleservice.repository;

import com.tim.mini.gamespot.articleservice.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
