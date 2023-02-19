package com.school.management.service;

import com.school.management.common.exception.handler.DataPresentException;
import com.school.management.common.response.ApiResponse;
import com.school.management.entity.User;
import com.school.management.model.UserModel;
import com.school.management.repositopry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApiResponse<String> registerUser(final UserModel userModel) {
        if (userRepository.findById(userModel.getUserName()).isPresent()) {
            throw new DataPresentException("User already present");
        } else {
            userRepository.save(new User(userModel.getUserName(), passwordEncoder.encode(userModel.getPassword())));
            return ApiResponse.<String>builder().data("User registration completed").build();
        }
    }
}
