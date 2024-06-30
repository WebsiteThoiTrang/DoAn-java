package com.nhom8.WebsiteThoiTrang.controller.admin;


import com.nhom8.WebsiteThoiTrang.model.admin.Category;
import com.nhom8.WebsiteThoiTrang.model.admin.Contact;
import com.nhom8.WebsiteThoiTrang.model.admin.Product;
import com.nhom8.WebsiteThoiTrang.service.admin.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contactad")
public class AdminContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public String index(Model model) {
        List<Contact> list =  this.contactService.getAll();
        model.addAttribute("list",list);
        return "/admin/contactad/index";
    }

    @GetMapping("/add-contactad")
    public String add(Model model) {
        model.addAttribute("contact", new Contact());
        return "/admin/contactad/add";
    }


    @PostMapping("/add-contactad")
    public String save(@Valid Contact contact, BindingResult result) {
        if(this.contactService.create(contact)) {
            return "redirect:/contactad";
        } else {
            return "redirect:/contactad/add-contactad";
        }
    }


}

