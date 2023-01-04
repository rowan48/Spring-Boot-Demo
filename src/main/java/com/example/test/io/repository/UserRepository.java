package com.example.test.io.repository;

import clojure.lang.Obj;
import com.example.test.io.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.example.test.io.entity.UserEntity;

import java.util.List;
import java.util.Objects;

public interface UserRepository extends CrudRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity,Long> {
    UserEntity findUserByEmail(String email);
    UserEntity findByUserId(String UserId);
  //  @Query( "select  from UserEntity user ")
 @Query("SELECT u.fullname,u.email FROM users u where u.email=:email")

    List<Objects[]> findUserEntitiesByEmail(@Param("email") String email);
}
