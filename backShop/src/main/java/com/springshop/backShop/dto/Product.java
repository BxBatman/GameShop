package com.springshop.backShop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.persistence.*;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;

    @ManyToOne
    @JoinColumn(name="category_id",insertable = false,updatable = false)
    Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Prosze wprowadzic nazwe produktu")
    private String name;
    @NotBlank(message = "Prosze wprowadzic wersje")
    private String brand;
    @JsonIgnore
    @NotBlank(message = "Prosze wprowadzic opis")
    private String description;
    @Column(name = "unit_price")
    @Min(value=1,message = "Cena nie moze byc nizsza niz 1")
    private double unitPrice;
    @Min(value = 0, message = "Ilosc nie moze byc mniejsza od 0")
    private int quantity;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name= "supplier_id")
    private int supplierId;
    private int purchases;
    private int views;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Transient
    private MultipartFile file;



    public Product(){
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", active=" + active +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", purchases=" + purchases +
                ", views=" + views +
                '}';
    }
}
