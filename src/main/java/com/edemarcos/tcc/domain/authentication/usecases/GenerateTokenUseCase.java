package com.edemarcos.tcc.domain.authentication.usecases;


import com.edemarcos.tcc.domain.user.entities.User;

public interface GenerateTokenUseCase {
    String execute(User user);
}
