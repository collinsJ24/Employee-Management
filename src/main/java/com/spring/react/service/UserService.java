package com.spring.react.service;

import com.spring.react.shared.userDTO;

public interface UserService{
    userDTO createUser(userDTO user);

    userDTO getUser(String userId);
}
