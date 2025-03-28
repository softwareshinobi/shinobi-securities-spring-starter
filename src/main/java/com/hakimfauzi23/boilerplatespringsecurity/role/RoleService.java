
package com.hakimfauzi23.boilerplatespringsecurity.role;

import com.hakimfauzi23.boilerplatespringsecurity.data.ERole;
import com.hakimfauzi23.boilerplatespringsecurity.data.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findRoleByName(ERole name) {
        return roleRepository.findByName(name);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role createRoleIfNotExists(ERole roleName) {
        Optional<Role> existingRole = roleRepository.findByName(roleName);
        if (existingRole.isPresent()) {
            return existingRole.get();
        } else {
            Role newRole = new Role(roleName);
            return roleRepository.save(newRole);
        }
    }

}