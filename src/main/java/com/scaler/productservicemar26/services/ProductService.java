package com.scaler.productservicemar26.services;

import com.scaler.productservicemar26.exceptions.ProductNotFoundException;
import com.scaler.productservicemar26.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
