package com.tim.mini.gamespot.userservice.service;

import com.tim.mini.gamespot.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    void deleteUser(long id);
}
