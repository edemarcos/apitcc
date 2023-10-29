package com.edemarcos.tcc.app.user.dataproviders.mapper;

import com.edemarcos.tcc.app.user.dataproviders.model.UserModel;
import com.edemarcos.tcc.domain.user.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel toModel(User user) {
        return new UserModel(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getRegistrationDate(),
                user.getActivated()
        );
    }

    public User toEntity(UserModel userModel) {
        return new User(
                userModel.getId(),
                userModel.getName(),
                userModel.getLogin(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getRole(),
                userModel.getRegistrationDate(),
                userModel.getActivated()
        );
    }

    public User toUserOfUserDetails(UserDetails userDetails) {
        return new User(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
    }
}
