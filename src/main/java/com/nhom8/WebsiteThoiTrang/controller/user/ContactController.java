package com.nhom8.WebsiteThoiTrang.controller.user;


import com.nhom8.WebsiteThoiTrang.repository.admin.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {


    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/contact")
    public String home() {
        return "user/contact/index";
    }





}





