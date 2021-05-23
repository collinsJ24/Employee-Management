package com.spring.react.service.impl;

import com.spring.react.io.entity.UserEntity;
import com.spring.react.io.repository.UserRepository;
import com.spring.react.service.UserService;
import com.spring.react.shared.userDTO;
import org.omg.CORBA.UnknownUserException;
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
        UserEntity storedUserDetails = userRepo.save(userEntity);
        userDTO returnedUser = new userDTO();
        BeanUtils.copyProperties(storedUserDetails, returnedUser);
        return returnedUser;
    }

    @Override
    public userDTO getUser(String userId){
        userDTO returnedUser = new userDTO();
        UserEntity storedUserDetails = userRepo.findByUserId(userId);
        if (storedUserDetails != null) {

            BeanUtils.copyProperties(storedUserDetails, returnedUser);
        }
        return returnedUser;
    }
}
