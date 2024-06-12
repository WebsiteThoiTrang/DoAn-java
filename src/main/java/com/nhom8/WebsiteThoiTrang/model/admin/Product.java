package com.nhom8.WebsiteThoiTrang.model.admin;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;
@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRO")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_CAT", referencedColumnName = "ID_CAT")
    private Category category;
    @Column(name = "NAME_PRO", nullable = false)
    private String name;
    @Column(name = "NUMS", nullable = false)
    private int nums;
    @Column(name = "PRICE", nullable = false)
    private double price;
    @Column(name = "DETAIL")
    private String detail;
    @Column(name = "META")
    private String meta;
    @Column(name = "`ORDER`", nullable = false)
    private int order;
    @Column(name = "LINK")
    private String link;
    @Column(name = "HIDE", nullable = false)
    private boolean hide;

    private String thumnail;
}