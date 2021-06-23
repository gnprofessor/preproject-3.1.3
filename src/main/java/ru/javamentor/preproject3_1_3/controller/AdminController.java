package ru.javamentor.preproject3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.preproject3_1_3.service.RoleService;
import ru.javamentor.preproject3_1_3.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(ModelMap model, Principal user) {
        model.addAttribute("user", userService.findUserByEmail(user.getName()));
        model.addAttribute("allRoles", roleService.findAll());
        return "admin-page";
    }
}
