package com.example.test.ui.Controller;

import com.example.test.exceptions.UserServiceException;
import com.example.test.io.entity.UserEntity;
import com.example.test.models.response.ErrorMessages;
import com.example.test.services.UserService;
import com.example.test.models.request.UserData;
import com.example.test.models.response.UserRet;
import com.example.test.shared.Dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.test.models.response.ErrorMessages.MISSING_REQUIRED_FIELD;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    public List<UserRet> getUsers(@RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "limit",defaultValue = "10")int limit){

        List<UserDto> userDtos ;
        List<UserRet> users = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        userDtos=userService.getAllUsers(page , limit);
        for(UserDto user : userDtos){
            UserRet userRet;
            userRet=modelMapper.map(user,UserRet.class);
            BeanUtils.copyProperties(user, userRet);
            users.add(userRet);

        }


        return users;
    }
@GetMapping(path = "/{id}")
    public UserRet getUser(@PathVariable String id){
    UserRet returneddata;
    UserDto userDto ;
    userDto=userService.getUserByUserId(id);
    ModelMapper modelMapper = new ModelMapper();
    returneddata=modelMapper.map(userDto,UserRet.class);
    return returneddata;
}

@PostMapping
    public UserRet createUser(@RequestBody UserData userData) throws Exception{
    if(userData.getFullname().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
    UserDto userDto ;
    UserDto createdUser;
    UserRet returneddata=new UserRet();
    ModelMapper modelMapper = new ModelMapper();
    userDto=modelMapper.map(userData,UserDto.class);
    //BeanUtils.copyProperties(userData, userDto);
    createdUser=userService.createUser(userDto);
    returneddata=modelMapper.map(createdUser,UserRet.class);

   // BeanUtils.copyProperties(createdUser, returneddata);
    return returneddata;
    }
@DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable String id){
    userService.deleteUser(id);
    }
    @PutMapping(path = "/{id}")
    public UserRet updateUser(@PathVariable String id,@RequestBody UserData userData)throws Exception{
        if(userData.getFullname().isEmpty() || userData.getEmail().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        UserDto userDto ;
        UserDto createdUser;
        UserRet returneddata=new UserRet();
        ModelMapper modelMapper = new ModelMapper();
        userDto=modelMapper.map(userData,UserDto.class);
       // BeanUtils.copyProperties(userData, userDto);
        createdUser=userService.updateUser(id,userDto);
        returneddata=modelMapper.map(createdUser,UserRet.class);
        //BeanUtils.copyProperties(createdUser, returneddata);
        return returneddata;
    }



}
