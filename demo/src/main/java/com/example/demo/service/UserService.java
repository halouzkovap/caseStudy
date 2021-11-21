package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUser();

    Optional<User> findUser(Integer id);

    void changeStatus(User id);

    User editUser(User user);

    void deleteUser(User user);


    void createUser(User user);

}
