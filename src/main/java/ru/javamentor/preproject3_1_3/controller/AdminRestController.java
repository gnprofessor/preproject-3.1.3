package ru.javamentor.preproject3_1_3.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.preproject3_1_3.model.Role;
import ru.javamentor.preproject3_1_3.model.User;
import ru.javamentor.preproject3_1_3.service.RoleService;
import ru.javamentor.preproject3_1_3.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PatchMapping("/users")
    public ResponseEntity<User> editUser(@RequestBody User user, @RequestParam(value = "roless", required = false) String[] roles) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> findAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }


}
