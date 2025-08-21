package com.tim.mini.gamespot.commentservice.repository;

import com.tim.mini.gamespot.commentservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByArticleId(Long articleId);
}
