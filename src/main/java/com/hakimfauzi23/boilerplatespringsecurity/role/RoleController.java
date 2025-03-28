/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hakimfauzi23.boilerplatespringsecurity.role;

import com.hakimfauzi23.boilerplatespringsecurity.data.ERole;
import com.hakimfauzi23.boilerplatespringsecurity.data.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

  //  public RoleController(){System.out.println("role controller!!!");}
    
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
//        Optional<Role> role = roleService.findRoleById(id);
//        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable ERole name) {
        Optional<Role> role = roleService.findRoleByName(name);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @PostMapping("/create-if-not-exists/{roleName}")
    public ResponseEntity<Role> createRoleIfNotExists(@PathVariable ERole roleName) {
        Role role = roleService.createRoleIfNotExists(roleName);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }
}
