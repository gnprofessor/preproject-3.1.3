package ru.javamentor.preproject3_1_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.preproject3_1_3.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
