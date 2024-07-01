package com.nhom8.WebsiteThoiTrang.service.admin;

import com.nhom8.WebsiteThoiTrang.model.admin.Contact;
import com.nhom8.WebsiteThoiTrang.repository.admin.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServicelmpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public List<Contact> getAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public Boolean create(Contact contact) {
        try {
            this.contactRepository.save(contact);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Contact find(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Contact Contact) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
