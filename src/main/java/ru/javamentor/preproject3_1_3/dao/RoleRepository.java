package ru.javamentor.preproject3_1_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.preproject3_1_3.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
