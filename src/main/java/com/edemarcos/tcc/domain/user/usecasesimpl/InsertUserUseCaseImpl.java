package com.edemarcos.tcc.domain.user.usecasesimpl;

import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import com.edemarcos.tcc.domain.user.entities.User;
import com.edemarcos.tcc.domain.user.enums.UserRole;
import com.edemarcos.tcc.domain.user.exceptions.UserAlredyExistsException;
import com.edemarcos.tcc.domain.user.exceptions.UserInsertionException;
import com.edemarcos.tcc.domain.user.usecases.InsertUserUseCase;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

public class InsertUserUseCaseImpl implements InsertUserUseCase {
    private UserDataProvider userDataProvider;

    public InsertUserUseCaseImpl(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override
    public User execute(User user) {
        var userAlreadyExists = userDataProvider.findByLogin(user.getLogin());

        if (userAlreadyExists != null) {
            throw new UserAlredyExistsException("Usuario já existe : " + userAlreadyExists.getEmail());
        }

        if ( user.getRegistrationDate() == null ) {
            user.setRegistrationDate(LocalDateTime.now());
        }

        if ( user.getRole() == null ) {
            user.setRole(UserRole.USER);
        }

        if ( user.getActivated() == null ) {
            user.setActivated(true);
        }

        Field[] fields = User.class.getDeclaredFields();
        List<String> fieldsToCheck = List.of( "name", "email", "password");

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (fieldsToCheck.contains(field.getName()) && field.get(user) == null) {
                    throw new UserInsertionException("O campo " + field.getName() + " não pode ser nulo.");
                }
                field.set(user, field.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userDataProvider.insert(user);
    }
}
