package com.example.test.services.impl;

import com.example.test.models.request.AddressData;
import com.example.test.services.UserService;
import com.example.test.io.repository.UserRepository;
import com.example.test.io.entity.UserEntity;
import com.example.test.shared.Dto.AddressDto;
import com.example.test.shared.Dto.UserDto;
import com.example.test.shared.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            if(userDto.getUseradresses()!=null) {
                for (int i = 0; i < userDto.getUseradresses().size(); i++) {
                    AddressDto addressdto = userDto.getUseradresses().get(i);
                    addressdto.setUseradresses(userDto);
                    addressdto.setAddressId(utils.generateAddressId(30));
                    userDto.getUseradresses().set(i, addressdto);
                }
            }
            UserEntity userEntity ;
            ModelMapper modelMapper = new ModelMapper();
            userEntity=modelMapper.map(userDto,UserEntity.class);
            //BeanUtils.copyProperties(userDto, userEntity);
            String publicUserId = utils.generateUserId(30);
           // String publicAddressId=utils.generateAddressId(30);
            userEntity.setUserId(publicUserId);
            userEntity.setEncryptePassword("123");
            //userEntity.setAddresses(userDto.getAddressDtos());
            //bCryptPasswordEncoder.encode(userDto.getPassword())
             userRepository.save(userEntity);
            userDto=modelMapper.map(userEntity,UserDto.class);
         // BeanUtils.copyProperties(userEntity, userDto);
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
        ModelMapper modelMapper = new ModelMapper();
        userDto=modelMapper.map(userEntity,UserDto.class);
       // BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) {
        UserEntity userEntity=userRepository.findByUserId(id);
        if(userEntity!=null){
            if(userDto.getEmail()!=null) {
                userEntity.setEmail(userDto.getEmail());
            }if (userDto.getFullname()!=null) {
                userEntity.setFullname(userDto.getFullname());

            }  if (userDto.getPassword()!=null) {
                userEntity.setPassword(userDto.getPassword());

            }
            userRepository.save(userEntity);

            BeanUtils.copyProperties(userEntity, userDto);


        }
        return userDto;
    }

    @Override
    public void deleteUser(String id) {
        UserEntity userEntity=userRepository.findByUserId(id);
        if(userEntity==null) throw new RuntimeException("no user found");
        else {
            userRepository.delete(userEntity);
        }


    }
@Override

    public List<UserDto> getAllUsers(int page , int limit) {
        if(page>0)page=page-1;
    Pageable paging = PageRequest.of(page, limit);
    Page<UserEntity> pagedResult = userRepository.findAll(paging);


    List<UserEntity> users = new ArrayList<UserEntity>();
    users= pagedResult.getContent();
        List<UserDto> userDtos = new ArrayList<UserDto>();
   // users= (List<UserEntity>) userRepository.findAll(paging);
    for(UserEntity user : users){
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDtos.add(userDto);

    }


        return userDtos;

    }


}