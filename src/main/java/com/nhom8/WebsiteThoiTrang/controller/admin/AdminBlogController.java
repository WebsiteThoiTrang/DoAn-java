package com.nhom8.WebsiteThoiTrang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminBlogController {
    @RequestMapping("/blogad")
    public String home() {
        return "admin/blogad/index";
    }
}