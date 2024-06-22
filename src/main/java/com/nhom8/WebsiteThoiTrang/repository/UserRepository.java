package com.nhom8.WebsiteThoiTrang.repository;

import com.nhom8.WebsiteThoiTrang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
