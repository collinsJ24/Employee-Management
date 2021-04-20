package com.spring.react.ui.controller;

import com.spring.react.ui.model.userRequestModelDetails;
import com.spring.react.ui.model.userRest;
import com.spring.react.service.UserService;
import com.spring.react.shared.userDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user";
    }

    @PostMapping
    public userRest createUser(@RequestBody userRequestModelDetails userRequestModel){
        userRest userResponse = new userRest();
        userDTO userDTO = new userDTO();
        BeanUtils.copyProperties(userRequestModel, userDTO);
        userDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, userResponse);
        return userResponse;
    }
}
