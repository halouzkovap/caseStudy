package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
        userRepository.save(new User("Petra", "Jabličková", UserStatus.ACTIVE, "email@com.cz", 77754677, getDate()));
        userRepository.save(new User("Jana", "Koukalová", UserStatus.ACTIVE, "email@com.cz", 778879777, getDate()));
        userRepository.save(new User("Luděk", "Král", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Petr", "Fiala", UserStatus.ACTIVE, "email@com.cz", 77777777,getDate()));
        userRepository.save(new User("Karel", "Zahrdník", UserStatus.ACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Katka", "Hal", UserStatus.ACTIVE, "email@com.cz", 77654777,getDate()));
        userRepository.save(new User("Maria", "Zeleninová", UserStatus.DEACTIVE, "email@com.cz", 77777,getDate()));
        userRepository.save(new User("Klára", "Staňková", UserStatus.DEACTIVE, "email@com.cz", 77744477,getDate()));
        userRepository.save(new User("Alena", "Zelená", UserStatus.DEACTIVE, "email@com.cz", 33377777,getDate()));
        userRepository.save(new User("Luboš", "Halda", UserStatus.ACTIVE, "email@com.cz", 777754657,getDate()));
        userRepository.save(new User("František", "Ficek", UserStatus.ACTIVE, "email@com.cz", 55577777,getDate()));
        userRepository.save(new User("Tomáš", "Sehnal", UserStatus.ACTIVE, "email@com.cz", 71117777,getDate()));
        userRepository.save(new User("Hana", "Králová", UserStatus.ACTIVE, "email@com.cz", 88877777,getDate()));
        userRepository.save(new User("Jan", "Nesehnal", UserStatus.ACTIVE, "email@com.cz", 7788777,getDate()));
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(Integer id) {
        Optional <User> user = userRepository.findById(id);
        return user.orElseThrow();
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

     LocalDate getDate() {
        LocalDate now = LocalDate.now();
        long randomDay = ThreadLocalRandom.current().nextLong(now.minusDays(30).toEpochDay(), now.toEpochDay());
        return LocalDate.ofEpochDay(randomDay);
    }

}
