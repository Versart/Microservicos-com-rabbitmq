package com.versart.ms.user.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserRequest( @NotBlank String name, @NotBlank @Email String email) {


}
