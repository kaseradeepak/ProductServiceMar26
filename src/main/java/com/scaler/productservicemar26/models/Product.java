package com.scaler.productservicemar26.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private int qty;

    @ManyToOne
    private Category category;


    // Product - Category : M:1
//    public Product from(FakeStoreProductDto fakeStoreProductDto) {
//        if (fakeStoreProductDto != null) {
//            Product product = new Product();
//            product.setId(fakeStoreProductDto.getId());
//            product.setTitle(fakeStoreProductDto.getTitle());
//            product.setDescription(fakeStoreProductDto.getDescription());
//            product.setPrice(fakeStoreProductDto.getPrice());
//            product.setImageUrl(fakeStoreProductDto.getImage());
//
//            Category category = new Category();
//            category.setTitle(fakeStoreProductDto.getCategory());
//            product.setCategory(category);
//
//            return product;
//        }
//
//        return null;
//    }
}