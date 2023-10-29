package com.edemarcos.tcc.app.user.entrypoint.request;

import com.edemarcos.tcc.domain.user.enums.UserRole;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String login;
    private String email;
    private String password;
    private UserRole role;
}
