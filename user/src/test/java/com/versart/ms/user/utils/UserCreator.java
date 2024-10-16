package com.versart.ms.user.utils;

import com.versart.ms.user.api.model.UserRequest;
import com.versart.ms.user.api.model.UserResponse;

import java.util.UUID;

public class UserCreator {


    public static UserRequest createUserRequest() {
        return UserRequest.builder()
                .email("emailteste@email.com")
                .name("John Doe")
                .build();
    }

    public static UserResponse createUserResponse() {
        return UserResponse.builder()
                .email("emailteste@email.com")
                .userId(UUID.randomUUID())
                .build();
    }
}
