package com.nhom8.WebsiteThoiTrang.controller.user;


import com.nhom8.WebsiteThoiTrang.model.Contact;

import com.nhom8.WebsiteThoiTrang.repository.ContactRepository;
import com.nhom8.WebsiteThoiTrang.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {
    @RequestMapping("/contact")
    public String home() {
        return "user/contact/index";
    }

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;


    @PostMapping
    public String submitContactForm(@Valid Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/contact/index";
        }
        contactService.saveContact(contact);
        model.addAttribute("successMessage", "Tin nhắn của bạn đã được gửi.");
        return "user/contact/index";
    }


}





