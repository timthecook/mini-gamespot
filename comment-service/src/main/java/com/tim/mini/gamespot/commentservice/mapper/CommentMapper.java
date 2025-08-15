package com.tim.mini.gamespot.commentservice.mapper;

import com.tim.mini.gamespot.commentservice.dto.CommentDTO;
import com.tim.mini.gamespot.commentservice.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toDTO(Comment comment);
    Comment toEntity(CommentDTO commentDTO);
}
