package com.versart.ms.user.api.model;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {

    private UUID userId;
    private String email;

}
