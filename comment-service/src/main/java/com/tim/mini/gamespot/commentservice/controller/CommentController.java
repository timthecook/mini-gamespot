package com.tim.mini.gamespot.commentservice.controller;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;
import com.tim.mini.gamespot.commentservice.repository.CommentRepository;
import com.tim.mini.gamespot.commentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO dto){
     return ResponseEntity.ok(commentService.updateComment(id, dto)) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getComments(@RequestParam(required = false) Long articleId) {
        try{
        if (articleId != null) {
            List<CommentDTO> comments = commentService.getCommentsByArticle(articleId);
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.ok(commentService.getAllComments());
        }
    } catch (Exception e){
        e.printStackTrace();
        return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

}
