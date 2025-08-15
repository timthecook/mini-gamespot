package com.tim.mini.gamespot.userservice.controller;

import com.tim.mini.gamespot.userservice.dto.UserDTO;
import com.tim.mini.gamespot.userservice.mapper.UserMapper;
import com.tim.mini.gamespot.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllArticles(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
