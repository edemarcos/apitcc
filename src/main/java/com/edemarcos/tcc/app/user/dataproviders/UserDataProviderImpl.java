package com.edemarcos.tcc.app.user.dataproviders;

import com.edemarcos.tcc.app.user.dataproviders.mapper.UserMapper;
import com.edemarcos.tcc.app.user.dataproviders.model.UserModel;
import com.edemarcos.tcc.app.user.dataproviders.repository.UserRepository;
import com.edemarcos.tcc.domain.user.dataproviders.UserDataProvider;
import com.edemarcos.tcc.domain.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataProviderImpl implements UserDataProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User insert(User user) {
        UserModel userSaved = userRepository.save(userMapper.toModel(user));
        return userMapper.toEntity(userSaved);
    }

    @Override
    public User findById(Long id) {

        var userModel = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));

        return userMapper.toEntity(userModel);
    }

    @Override
    public List<User> findAll() {
        int num = userRepository.findAll().size();
        System.out.println(num);
        List<UserModel> usersListModel = userRepository.findAll();

        var userList = userMapper.toModelList(usersListModel);

        return userList;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findByEmail(String email) {
        var user = userRepository.findByEmail(email);
        if (user == null) return null;
        return userMapper.toEntity(user);
    }

    @Override
    public User findByLogin(String login) {
        var userDetails = userRepository.findByLogin(login);
        if (userDetails == null) return null;
        return userMapper.toUserOfUserDetails(userDetails);
    }
}
