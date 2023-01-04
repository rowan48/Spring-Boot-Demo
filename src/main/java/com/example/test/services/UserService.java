package com.example.test.services;

import com.example.test.io.entity.UserEntity;
import com.example.test.shared.Dto.UserDto;

import java.util.List;
import java.util.Objects;

public interface UserService  {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String id);
    UserDto updateUser(String id ,UserDto userDto);
    void deleteUser(String id);
    List<UserDto> getAllUsers(int page, int limit);
    UserDto getAddressByUser(String userId,String addressId);
    List<Objects[]> findUserEntitiesByEmail(String email);
}
