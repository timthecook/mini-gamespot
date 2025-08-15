package com.tim.mini.gamespot.articleservice.service;

import com.tim.mini.gamespot.articleservice.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO);
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getAllArticles();
    void deleteArticle(long id);
}
