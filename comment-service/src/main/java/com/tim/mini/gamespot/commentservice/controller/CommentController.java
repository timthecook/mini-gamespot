package com.tim.mini.gamespot.commentservice.controller;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;
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

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        return ResponseEntity.ok(commentService.getAllComments());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

}
