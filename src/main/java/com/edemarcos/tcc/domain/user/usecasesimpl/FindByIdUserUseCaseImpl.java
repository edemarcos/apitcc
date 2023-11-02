package com.edemarcos.tcc.domain.user.usecasesimpl;

import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.usecases.FindByIdUserUseCase;

public class FindByIdUserUseCaseImpl implements FindByIdUserUseCase {

    private final UserDataProvider userDataProvider;

    public FindByIdUserUseCaseImpl(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override
    public User execute(Long id) {
        return userDataProvider.findById(id);
    }
}
