package com.nhom8.WebsiteThoiTrang.service.admin;

import com.nhom8.WebsiteThoiTrang.model.admin.Category;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategoryById(Long id);

    Category findById(Long id);
}
