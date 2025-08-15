package com.tim.mini.gamespot.articleservice.mapper;

import com.tim.mini.gamespot.articleservice.dto.ArticleDTO;
import com.tim.mini.gamespot.articleservice.entity.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDTO toDTO(Article article);
    Article toEntity(ArticleDTO articleDTO);
}
