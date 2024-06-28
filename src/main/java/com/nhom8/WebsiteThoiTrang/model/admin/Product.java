package com.nhom8.WebsiteThoiTrang.model.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "image_url")
    private String imageUrl;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {}

    public Product(String name, String description, double price, String size, int quantity, String imageUrl, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    // Getters and setters

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUpdatedDate(LocalDateTime now) {
    }
}
