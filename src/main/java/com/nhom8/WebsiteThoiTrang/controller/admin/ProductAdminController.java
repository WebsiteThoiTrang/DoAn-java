package com.nhom8.WebsiteThoiTrang.controller.admin;

import com.nhom8.WebsiteThoiTrang.model.admin.Category;
import com.nhom8.WebsiteThoiTrang.model.admin.Product;
import com.nhom8.WebsiteThoiTrang.service.admin.CategoryService;
import com.nhom8.WebsiteThoiTrang.service.admin.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Value("${upload.folder}")
    private String uploadFolder;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("timestamp", System.currentTimeMillis());
        return "admin/product/products";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        return "admin/product/add-product";
    }

    @PostMapping("/add")
    public String addProduct(@Valid Product product, BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {
        if (result.hasErrors()) {
            return "admin/product/add-product";
        }

        if (!imageFile.isEmpty()) {
            try {
                String imageUrl = saveImage(imageFile);
                product.setImageUrl(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product ID: " + id);
        }
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String editProduct(@Valid Product product, BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {
        if (result.hasErrors()) {
            return "admin/product/edit-product";
        }

        Product existingProduct = productService.getProductById(product.getId());
        if (existingProduct == null) {
            throw new IllegalArgumentException("Invalid product ID: " + product.getId());
        }

        if (!imageFile.isEmpty()) {
            try {
                if (existingProduct.getImageUrl() != null) {
                    Path oldImagePath = Paths.get(uploadFolder + existingProduct.getImageUrl().substring(existingProduct.getImageUrl().lastIndexOf("/") + 1));
                    Files.deleteIfExists(oldImagePath);
                }
                String imageUrl = saveImage(imageFile);
                product.setImageUrl(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            product.setImageUrl(existingProduct.getImageUrl());
        }

        productService.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product ID: " + id);
        }
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "admin/product/edit-product";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @Valid Product product, BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {
        if (result.hasErrors()) {
            product.setId(id);
            return "admin/product/edit-product";
        }

        if (!imageFile.isEmpty()) {
            try {
                String imageUrl = saveImage(imageFile);
                product.setImageUrl(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productService.updateProduct(product);
        return "redirect:/products";
    }

    // Save image method
    private String saveImage(MultipartFile imageFile) throws IOException {
        if (imageFile.isEmpty()) {
            return null;
        }

        byte[] bytes = imageFile.getBytes();
        String uniqueFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        Path path = Paths.get(uploadFolder + uniqueFileName);
        Files.write(path, bytes);

        return "/assets/images/upload/product/" + uniqueFileName;
    }
}
