package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.Role;
import com.codegym.case43kshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
