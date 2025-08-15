package com.tim.mini.gamespot.commentservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {
    private Long id;
    private String content;
    private Long articleId;
    private Long userId;
    private LocalDateTime createdAt;

}
