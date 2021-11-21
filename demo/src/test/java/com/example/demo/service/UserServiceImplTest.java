package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    private UserRepository userRepository = mock(UserRepository.class);
    private UserServiceImpl userService;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void findAllUserSuccess() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(new User(1, "joe", "doe", UserStatus.ACTIVE, "emial", 7777, userService.getDate())));
        List<User> userList = userService.findAllUser();

        assertTrue(userList.size() == 1);
    }

}
