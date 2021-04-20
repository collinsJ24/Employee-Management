package com.spring.react.service.impl;

import com.spring.react.io.entity.UserEntity;
import com.spring.react.io.repository.UserRepository;
import com.spring.react.service.UserService;
import com.spring.react.shared.userDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public userDTO createUser(userDTO user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("test");
        UserEntity storedUserDetails = userRepo.save(userEntity);
        userDTO returnedUser = new userDTO();
        BeanUtils.copyProperties(storedUserDetails, returnedUser);
        return returnedUser;
    }
}
