package com.nhom8.WebsiteThoiTrang.controller.user;

import com.nhom8.WebsiteThoiTrang.model.admin.Product;
import com.nhom8.WebsiteThoiTrang.service.admin.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping()
    public String home(Model model) {
        List<Product> getAllProducts = productService.getAllProducts();
        model.addAttribute("products",getAllProducts);
        return "/user/product/index";
    }
}
