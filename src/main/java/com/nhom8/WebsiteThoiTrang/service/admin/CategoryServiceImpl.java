package com.nhom8.WebsiteThoiTrang.service.admin;
import com.nhom8.WebsiteThoiTrang.model.admin.Category;
import com.nhom8.WebsiteThoiTrang.repository.admin.CategoryRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    @Override
    public void updateCategory(@NotNull Category category) {
        Category existingCategory = categoryRepository.findById((long)
                        category.getId())
                .orElseThrow(() -> new IllegalStateException("Category with ID " +
                        category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
    }
    @Override
    public void deleteCategoryById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        categoryRepository.deleteById(id);
    }
    // Trong CategoryService
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}