package com.tim.mini.gamespot.commentservice.service;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;
import com.tim.mini.gamespot.commentservice.entity.Comment;
import com.tim.mini.gamespot.commentservice.exception.CommentNotFoundException;
import com.tim.mini.gamespot.commentservice.mapper.CommentMapper;
import com.tim.mini.gamespot.commentservice.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not Found."));
        return commentMapper.toDTO(comment);
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return commentRepository
                .findAll()
                .stream()
                .map(commentMapper::toDTO)
                .collect(Collectors
                        .toList());
    }

    @Override
    public void deleteComment(long id) {
    if (!commentRepository.existsById(id)){
        throw new CommentNotFoundException("Comment not found.");
    }
    commentRepository.deleteById(id);
    }
}
