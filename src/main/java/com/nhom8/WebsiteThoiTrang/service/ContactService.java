package com.nhom8.WebsiteThoiTrang.service;

import com.nhom8.WebsiteThoiTrang.model.Contact;
import com.nhom8.WebsiteThoiTrang.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


@Service
@SessionScope
public class ContactService {

    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

}