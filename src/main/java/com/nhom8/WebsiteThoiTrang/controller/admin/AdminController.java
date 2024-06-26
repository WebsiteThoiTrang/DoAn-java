package com.nhom8.WebsiteThoiTrang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping
    public String admin() {
        return "/admin/index";
    }

    @GetMapping("/categories")
    public String AdminCategory() {
        return "/admin/category/categories";
    }
    @GetMapping("/products")
    public String AdminProduct() {
        return "/admin/product/products";
    }

}
