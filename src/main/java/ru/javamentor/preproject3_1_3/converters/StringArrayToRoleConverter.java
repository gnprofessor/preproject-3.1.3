package ru.javamentor.preproject3_1_3.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.javamentor.preproject3_1_3.model.Role;
import ru.javamentor.preproject3_1_3.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@Component
public class StringArrayToRoleConverter implements Converter<String[], Set<Role>> {

    @Autowired
    private RoleService roleService;

    @Override
    public Set<Role> convert(String[] strings) {
        Set<Role> roleSet = new HashSet<>();
        for (String string : strings) {
            if (string.equals("ROLE_ADMIN")) {
                roleSet.add(roleService.findAll().get(0));
            }
            if (string.equals("ROLE_USER")) {
                roleSet.add(roleService.findAll().get(1));
            }
        }
        return roleSet;
    }
}
