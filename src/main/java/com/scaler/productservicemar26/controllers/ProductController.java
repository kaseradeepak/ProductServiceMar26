package com.scaler.productservicemar26.controllers;

import com.scaler.productservicemar26.models.Product;
import com.scaler.productservicemar26.services.FakeStoreProductService;
import com.scaler.productservicemar26.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
//    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Everyone!";
    }

    // CRUD Operations on Product Model.

    // https://www.amazon.in/products/123
    // http://localhost:8080/products/123
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) {
        Product product = productService.getProductById(productId);
        return product;
    }

    //Get all the products.
    // http://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return null;
    }

}

// ProductController -> ProductService
