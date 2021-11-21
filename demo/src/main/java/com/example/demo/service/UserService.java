package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUser();

    User findUser(Integer id);

    User editUser(User user);

    void deleteUser(User user);


}
