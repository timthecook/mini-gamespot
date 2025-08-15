package com.tim.mini.gamespot.commentservice.service;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO comment);
    CommentDTO getCommentById(Long id);
    List<CommentDTO> getAllComments();
    void deleteUser(long id);
}
