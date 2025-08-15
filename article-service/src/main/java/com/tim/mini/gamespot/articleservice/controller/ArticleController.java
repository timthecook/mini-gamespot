package com.tim.mini.gamespot.articleservice.controller;

import com.tim.mini.gamespot.articleservice.dto.ArticleDTO;
import com.tim.mini.gamespot.articleservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDTO>create(@RequestBody ArticleDTO articleDTO){
        return ResponseEntity.ok(articleService.createArticle(articleDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO>getArticleById(@PathVariable Long id){
        return ResponseEntity.ok(articleService.getArticleById(id));
    }
    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles(){
        return ResponseEntity.ok(articleService.getAllArticles());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
