package com.nhom8.WebsiteThoiTrang.repository.admin;
import com.nhom8.WebsiteThoiTrang.model.admin.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
