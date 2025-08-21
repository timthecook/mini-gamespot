package com.tim.mini.gamespot.commentservice.service;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO comment);
    CommentDTO getCommentById(Long id);
    CommentDTO updateComment(Long id, CommentDTO dto);
    List<CommentDTO> getAllComments();
    List<CommentDTO> getCommentsByArticle(Long articleId);
    void deleteComment(long id);


}
