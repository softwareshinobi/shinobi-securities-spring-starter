/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hakimfauzi23.boilerplatespringsecurity.role;

import com.hakimfauzi23.boilerplatespringsecurity.data.Role;
import com.hakimfauzi23.boilerplatespringsecurity.data.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Optional<Role> findByName(ERole name);
    
}