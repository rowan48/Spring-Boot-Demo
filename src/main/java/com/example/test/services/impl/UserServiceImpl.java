package com.example.test.services.impl;

import com.example.test.services.UserService;
import com.example.test.io.repository.UserRepository;
import com.example.test.io.entity.UserEntity;
import com.example.test.shared.Dto.UserDto;
import com.example.test.shared.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userRepository.findUserByEmail(userDto.getEmail())==null){
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDto, userEntity);
            String publicUserId = utils.generateUserId(30);
            userEntity.setUserId(publicUserId);
            userEntity.setEncryptePassword("123");
            //bCryptPasswordEncoder.encode(userDto.getPassword())
            userRepository.save(userEntity);
            BeanUtils.copyProperties(userEntity, userDto);
        }else{
            throw new RuntimeException("user already exist");
        }
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String id) {
        UserEntity userEntity = new UserEntity();
        UserDto userDto = new UserDto();
        userEntity =userRepository.findByUserId(id);
        BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }
}