package com.edemarcos.tcc.app.user.entrypoint.response;

import com.edemarcos.tcc.domain.user.enums.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String name;
    private String login;
    private String email;
    private UserRole role;
    private LocalDateTime registrationDate;
    private Boolean isActivated;
}
