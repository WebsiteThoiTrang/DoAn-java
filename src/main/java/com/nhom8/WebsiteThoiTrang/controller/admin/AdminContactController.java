package com.nhom8.WebsiteThoiTrang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminContactController {
    @RequestMapping("admin/admincontact")
    public String admin() {
        return "admin/admincontact/index";
    }
}