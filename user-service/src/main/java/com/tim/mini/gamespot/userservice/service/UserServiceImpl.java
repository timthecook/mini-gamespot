package com.tim.mini.gamespot.userservice.service;

import com.tim.mini.gamespot.userservice.dto.UserDTO;
import com.tim.mini.gamespot.userservice.entity.UserEntity;
import com.tim.mini.gamespot.userservice.mapper.UserMapper;
import com.tim.mini.gamespot.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));
        return userMapper.toDTO(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll().stream().map(userMapper::toDTO)
                .collect(Collectors
                        .toList());
    }

    @Override
    public void deleteUser(long id) {
    if (!userRepository.existsById(id)){
        throw new RuntimeException("User not found.");
    }
    userRepository.deleteById(id);
    }
}
