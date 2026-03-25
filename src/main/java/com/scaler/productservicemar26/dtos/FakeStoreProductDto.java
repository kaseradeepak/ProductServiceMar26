package com.scaler.productservicemar26.dtos;

import com.scaler.productservicemar26.models.Category;
import com.scaler.productservicemar26.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}
