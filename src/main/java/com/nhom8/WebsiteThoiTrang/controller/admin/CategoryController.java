package com.nhom8.WebsiteThoiTrang.controller.admin;

import com.nhom8.WebsiteThoiTrang.model.admin.Category;
import com.nhom8.WebsiteThoiTrang.service.admin.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Lấy danh sách tất cả các danh mục
    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/category/categories";
    }

    // Hiển thị form thêm danh mục mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category/category-form";
    }

    // Xử lý thêm danh mục mới
    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/category/category-form";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category, Model model) {
        categoryService.updateCategory(category);
        return "redirect:/categories"; // Chuyển hướng về trang danh sách categories
    }
    // Hiển thị form cập nhật danh mục
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            throw new IllegalArgumentException("ID danh mục không hợp lệ: " + id);
        }
        model.addAttribute("category", category);
        return "admin/category/category-form";
    }

    // Xử lý cập nhật danh mục
    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") Long id, @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            category.setId(id); // Sử dụng Long thay vì int
            return "admin/category/category-form";
        }
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }

    // Xử lý xóa danh mục
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            throw new IllegalArgumentException("ID danh mục không hợp lệ: " + id);
        }
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
