package com.nhom8.WebsiteThoiTrang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/admin")
@Controller
public class AdminController {
    @GetMapping
    public String admin() {
        return "admin/index";
    }

        @GetMapping("/admincontact")
        public String AdminContact() {
            return "admin/admincontact/index";
        }

}
