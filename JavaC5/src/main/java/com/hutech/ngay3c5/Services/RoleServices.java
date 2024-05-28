package com.hutech.ngay3c5.Services;

import com.hutech.ngay3c5.Entities.Role;
import com.hutech.ngay3c5.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Role not found")
        );
    }
    public Role createRole(Role classroom) {
        return roleRepository.save(classroom);
    }
}