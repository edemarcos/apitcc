package com.edemarcos.tcc.domain.user.usecases;

import com.edemarcos.tcc.domain.user.entities.User;

public interface InsertUserUseCase {
    User execute(User user);
}
