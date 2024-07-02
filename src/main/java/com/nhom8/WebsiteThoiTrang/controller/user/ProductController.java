package com.nhom8.WebsiteThoiTrang.controller.user;

import com.nhom8.WebsiteThoiTrang.model.admin.Product;
import com.nhom8.WebsiteThoiTrang.service.admin.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

//    @GetMapping("/detail")
//    public String detail() {
//
//        return "/user/product/detail";
//    }

    @GetMapping("/detail")
    public String showProductDetail(@RequestParam("id") Long id, Model model) {
        // Retrieve product details from the service based on productId
        Product product = productService.getProductById(id);
        // Add product object to the model to be accessed by Thymeleaf template
        model.addAttribute("product", product);
        return "/user/product/detail"; // Returns the name of the Thymeleaf template (productDetail.html)
    }
}
