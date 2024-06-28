package com.nhom8.WebsiteThoiTrang.repository;


import com.nhom8.WebsiteThoiTrang.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
