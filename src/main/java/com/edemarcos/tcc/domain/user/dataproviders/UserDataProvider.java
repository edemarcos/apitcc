package com.edemarcos.tcc.domain.user.dataproviders;

import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.user.entities.User;

import java.util.List;

public interface UserDataProvider {
    User insert(User user);
    User findById(Long id);
    List<User> findAll();
    void update(User user);
    void delete(Long id);
    User findByEmail(String email);

    User findByLogin(String email);
}
