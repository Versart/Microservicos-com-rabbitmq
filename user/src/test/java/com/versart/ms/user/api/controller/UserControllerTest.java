package com.versart.ms.user.api.controller;

import com.versart.ms.user.api.model.UserRequest;
import com.versart.ms.user.api.model.UserResponse;
import com.versart.ms.user.domain.service.UserService;
import com.versart.ms.user.utils.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userServiceMock;

    @BeforeEach
    void setup() {
        Mockito.when(userServiceMock.saveUser(ArgumentMatchers.any(UserRequest.class)))
                .thenReturn(UserCreator.createUserResponse());
    }

    @Test
    @DisplayName("saveUser returns UserResponse when successful")
    void saveUser_ReturnsUserResponse_WhenSucessful() {
        UserRequest userRequest = UserCreator.createUserRequest();

        UserResponse userResponse = userController.saveUser(userRequest).getBody();

        Assertions.assertThat(userResponse).isNotNull();

        Assertions.assertThat(userResponse.getUserId()).isNotNull();

    }
}