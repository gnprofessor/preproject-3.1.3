package ru.javamentor.preproject3_1_3.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.preproject3_1_3.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserByEmail(String email);
    List<User> findAll();
    User findById(long id);
    User saveUser(User user);
    void deleteUser(long id);
}
