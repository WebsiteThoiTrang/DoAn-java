package com.nhom8.WebsiteThoiTrang.repository;

import com.nhom8.WebsiteThoiTrang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);

}
