package com.nhom8.WebsiteThoiTrang.service.admin;

import com.nhom8.WebsiteThoiTrang.model.admin.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();
     Boolean create(Contact contact);
     Contact find(Integer id);
     Boolean update(Contact Contact);
     Boolean delete(Integer id);

}
