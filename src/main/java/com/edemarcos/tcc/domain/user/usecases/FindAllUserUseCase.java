package com.edemarcos.tcc.domain.user.usecases;

import com.edemarcos.tcc.domain.user.entities.User;

import java.util.List;

public interface FindAllUserUseCase {

    List<User> execute();
}
