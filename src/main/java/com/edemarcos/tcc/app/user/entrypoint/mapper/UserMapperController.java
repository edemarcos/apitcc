package com.edemarcos.tcc.app.user.entrypoint.mapper;

import com.edemarcos.tcc.app.user.entrypoint.request.UserRequest;
import com.edemarcos.tcc.app.user.entrypoint.response.UserResponse;
import com.edemarcos.tcc.domain.user.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperController {
    public User toUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setLogin(userRequest.getLogin());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        return user;
    }

    public UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setLogin(user.getLogin());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        userResponse.setRegistrationDate(user.getRegistrationDate());
        userResponse.setIsActivated(user.getActivated());
        return userResponse;
    }
}
