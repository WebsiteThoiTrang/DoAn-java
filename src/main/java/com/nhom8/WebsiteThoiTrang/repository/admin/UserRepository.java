package com.nhom8.WebsiteThoiTrang.repository.admin;
import com.nhom8.WebsiteThoiTrang.model.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}