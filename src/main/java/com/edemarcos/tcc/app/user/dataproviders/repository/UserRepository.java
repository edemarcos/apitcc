package com.edemarcos.tcc.app.user.dataproviders.repository;

import com.edemarcos.tcc.app.user.dataproviders.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);

    UserDetails findByLogin(String login);
}
