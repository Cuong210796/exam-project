package com.cuong.service;

import com.cuong.model.Role;
import com.cuong.model.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName roleName);
}
