package com.nhom8.WebsiteThoiTrang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    @RequestMapping("/blog")
    public String home() {
        return "user/blog/index";
    }
}
