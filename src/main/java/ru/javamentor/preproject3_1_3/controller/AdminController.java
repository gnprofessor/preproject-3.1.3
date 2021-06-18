package ru.javamentor.preproject3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.preproject3_1_3.converters.StringArrayToRoleConverter;
import ru.javamentor.preproject3_1_3.model.User;
import ru.javamentor.preproject3_1_3.service.RoleService;
import ru.javamentor.preproject3_1_3.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private StringArrayToRoleConverter roleConverter;

    @GetMapping()
    public String index(ModelMap model, Principal user) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", userService.findUserByEmail(user.getName()));
        model.addAttribute("allRoles", roleService.findAll());
        model.addAttribute("newUser", new User());
        return "admin-page";
    }

   /* @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "roless", required = false) String[] roles) {
        user.setRoles(roleConverter.convert(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }*/

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("allRoles", roleService.findAll());
        return "form";
    }

    /*@PatchMapping()
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "roless", required = false) String[] roles) {
        user.setRoles(roleConverter.convert(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }*/

    @DeleteMapping()
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/admin";
    }
}
