package com.tim.mini.gamespot.articleservice.service;

import com.tim.mini.gamespot.articleservice.dto.ArticleDTO;
import com.tim.mini.gamespot.articleservice.entity.Article;
import com.tim.mini.gamespot.articleservice.exception.ArticleNotFoundException;
import com.tim.mini.gamespot.articleservice.mapper.ArticleMapper;
import com.tim.mini.gamespot.articleservice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        return articleMapper.toDTO(articleRepository.save(article));
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Article Not Found"));
        return articleMapper.toDTO(article);
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return articleRepository
                .findAll()
                .stream()
                .map(articleMapper::toDTO)
                .collect(Collectors
                        .toList());
    }

    @Override
    public void deleteArticle(long id) {
    if (!articleRepository.existsById(id)){
        throw new ArticleNotFoundException("Article not found.");
    }
    articleRepository.deleteById(id);
    }
}
