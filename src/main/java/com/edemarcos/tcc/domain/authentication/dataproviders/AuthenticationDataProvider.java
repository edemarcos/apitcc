package com.edemarcos.tcc.domain.authentication.dataproviders;


import com.edemarcos.tcc.domain.user.entities.User;

public interface AuthenticationDataProvider {
    Object loadUserByUsername(String username);

    String generateToken(User user);

    String validateToken(String token);
}
