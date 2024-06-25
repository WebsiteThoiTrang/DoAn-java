package com.nhom8.WebsiteThoiTrang.repository;

import com.nhom8.WebsiteThoiTrang.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}
