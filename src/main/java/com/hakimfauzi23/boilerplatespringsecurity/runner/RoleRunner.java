package com.hakimfauzi23.boilerplatespringsecurity.runner;

import com.hakimfauzi23.boilerplatespringsecurity.data.ERole;
import com.hakimfauzi23.boilerplatespringsecurity.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleRunner implements CommandLineRunner {

    private final RoleService roleService;

    @Autowired
    public RoleRunner(RoleService roleService) {
        
        this.roleService = roleService;
        
    }

    @Override
    public void run(String... args) throws Exception {
        
        roleService.createRoleIfNotExists(ERole.ROLE_USER);

        roleService.createRoleIfNotExists(ERole.ROLE_ADMIN);

        //You can add more roles here if you want.
        //roleService.createRoleIfNotExists(ERole.ROLE_MODERATOR);
        
        System.out.println("Roles initialized.");
        
    }
}
