package com.tim.mini.gamespot.commentservice.service;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;
import com.tim.mini.gamespot.commentservice.entity.Comment;
import com.tim.mini.gamespot.commentservice.mapper.CommentMapper;
import com.tim.mini.gamespot.commentservice.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

        private final CommentRepository commentRepository;
        private final CommentMapper commentMapper;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        return commentMapper.toDTO(commentRepository.save(comment));
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        return null;
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return List.of();
    }

    @Override
    public void deleteUser(long id) {

    }
}
