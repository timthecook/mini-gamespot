package com.tim.mini.gamespot.userservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String role;
    private LocalDate createdAt;
}
