package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.exception.UserNotFoundException;
import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
