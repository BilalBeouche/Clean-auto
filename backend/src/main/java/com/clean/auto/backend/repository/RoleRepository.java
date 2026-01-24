package com.clean.auto.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean.auto.backend.entity.Role;
import com.clean.auto.backend.enums.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByTypeRole(RoleType typeRole);

}
