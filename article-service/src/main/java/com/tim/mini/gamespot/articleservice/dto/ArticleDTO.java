package com.tim.mini.gamespot.articleservice.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    private LocalDate createdAt;
}
