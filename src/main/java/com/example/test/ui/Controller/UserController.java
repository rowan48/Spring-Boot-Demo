package com.example.test.ui.Controller;

import com.example.test.exceptions.UserServiceException;
import com.example.test.models.response.ErrorMessages;
import com.example.test.services.UserService;
import com.example.test.models.request.UserData;
import com.example.test.models.response.UserRet;
import com.example.test.shared.Dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.test.models.response.ErrorMessages.MISSING_REQUIRED_FIELD;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
@GetMapping(path = "/{id}")
    public UserRet getUser(@PathVariable String id){
    UserRet returneddata=new UserRet();
    UserDto userDto = new UserDto();


    userDto=userService.getUserByUserId(id);
    BeanUtils.copyProperties(userDto, returneddata);

    return returneddata;
}
@PostMapping
    public UserRet createUser(@RequestBody UserData userData) throws Exception{
    if(userData.getFullname().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
    UserDto userDto = new UserDto();
    UserDto createdUser;
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
