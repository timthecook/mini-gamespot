package com.tim.mini.gamespot.userservice.repository;

import com.tim.mini.gamespot.userservice.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
