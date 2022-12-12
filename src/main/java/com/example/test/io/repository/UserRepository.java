package com.example.test.io.repository;

import com.example.test.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity,Long> {
    UserEntity findUserByEmail(String email);
    UserEntity findByUserId(String UserId);
}
