package com.nhom8.WebsiteThoiTrang.repository.admin;
import com.nhom8.WebsiteThoiTrang.model.admin.Product ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}