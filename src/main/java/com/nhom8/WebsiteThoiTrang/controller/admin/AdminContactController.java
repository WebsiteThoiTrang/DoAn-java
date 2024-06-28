package com.nhom8.WebsiteThoiTrang.controller.admin;

import com.nhom8.WebsiteThoiTrang.model.Contact;

import com.nhom8.WebsiteThoiTrang.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/contactad")

    public String home() {
        return "admin/contactad/index";
    }



}