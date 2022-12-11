package com.example.test.io.repository;

import com.example.test.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserByEmail(String email);
    UserEntity findByUserId(String UserId);
}
