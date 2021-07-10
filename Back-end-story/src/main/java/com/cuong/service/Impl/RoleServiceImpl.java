package com.cuong.service.Impl;

import com.cuong.model.Role;
import com.cuong.model.RoleName;
import com.cuong.repository.RoleRepository;
import com.cuong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }
}
