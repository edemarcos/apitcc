package com.edemarcos.tcc.domain.user.usecases;

import com.edemarcos.tcc.domain.user.entities.User;

public interface FindByIdUserUseCase {
    User execute(Long id);
}
