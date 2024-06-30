package com.nhom8.WebsiteThoiTrang.repository.admin;


import com.nhom8.WebsiteThoiTrang.model.admin.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
