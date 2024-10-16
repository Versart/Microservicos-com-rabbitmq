package com.versart.ms.user.domain.service;

import com.versart.ms.user.api.model.UserRequest;
import com.versart.ms.user.api.model.UserResponse;
import com.versart.ms.user.domain.model.User;
import com.versart.ms.user.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public UserResponse saveUser(UserRequest userRequest) {
        var user = new User();
        BeanUtils.copyProperties(userRequest, user);
        User usersaved = userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(usersaved,userResponse);
        return userResponse;
    }
}
