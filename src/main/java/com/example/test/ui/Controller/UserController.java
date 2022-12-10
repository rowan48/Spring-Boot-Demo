package com.example.test.ui.Controller;

import com.example.test.services.UserService;
import com.example.test.models.request.UserData;
import com.example.test.models.response.UserRet;
import com.example.test.shared.Dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
@GetMapping
    public String getUser(){
    return "get users";
}
@PostMapping
    public UserRet createUser(@RequestBody UserData userData){
    UserDto userDto = new UserDto();
    UserDto createdUser = new UserDto();
    UserRet returneddata=new UserRet();

    BeanUtils.copyProperties(userData, userDto);
    createdUser=userService.createUser(userDto);
    BeanUtils.copyProperties(createdUser, returneddata);


    return returneddata;
    }
@DeleteMapping
    public UserRet deleteUser(){
        return null;
    }
    @PutMapping
    public UserRet updateUser(){
        return null;
    }
}
