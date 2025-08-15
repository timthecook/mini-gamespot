package com.tim.mini.gamespot.userservice.mapper;

import com.tim.mini.gamespot.userservice.dto.UserDTO;
import com.tim.mini.gamespot.userservice.entity.UserEntity;
import org.apache.catalina.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO (UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}
