package com.edemarcos.tcc.domain.user.usecasesimpl;

import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.usecases.FindAllUserUseCase;

import java.util.List;

public class FindAllUserUseCaseImpl implements FindAllUserUseCase {

    private final UserDataProvider userDataProvider;

    public FindAllUserUseCaseImpl(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override
    public List<User> execute() {
        var usersList = userDataProvider.findAll();
        return usersList;
    }
}
