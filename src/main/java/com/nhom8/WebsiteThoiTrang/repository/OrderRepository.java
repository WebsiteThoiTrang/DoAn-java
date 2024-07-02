package com.nhom8.WebsiteThoiTrang.repository;

import com.nhom8.WebsiteThoiTrang.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
