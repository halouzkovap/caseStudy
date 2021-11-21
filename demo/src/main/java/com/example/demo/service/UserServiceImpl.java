package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void init() {
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777, getDate()));
        userRepository.save(new User("Jana", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777, getDate()));
        userRepository.save(new User("Honza", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Karel", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Klára", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Luboš", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Tomáš", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petra", "Hal", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUser(Integer id) {
        try {
            return userRepository.findById(id);
        } catch (NullPointerException e) {
            throw new NullPointerException("User doesnt exist");
        }
    }

    @Override
    public void changeStatus(User user) {
        userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

     LocalDate getDate() {
        LocalDate now = LocalDate.now();
        long randomDay = ThreadLocalRandom.current().nextLong(now.minusDays(30).toEpochDay(), now.toEpochDay());
        return LocalDate.ofEpochDay(randomDay);
    }

}
