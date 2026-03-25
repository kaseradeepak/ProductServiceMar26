package com.scaler.productservicemar26.controllers;

import com.scaler.productservicemar26.ProductServiceMar26Application;
import com.scaler.productservicemar26.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicemar26.exceptions.ProductNotFoundException;
import com.scaler.productservicemar26.models.Product;
import com.scaler.productservicemar26.services.FakeStoreProductService;
import com.scaler.productservicemar26.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        if (productId <= 0) {
            throw new IllegalArgumentException("productId should be greater than 0");
        }

        //Either handle the exception or throw it as it is.
        Product product = productService.getProductById(productId);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Get all the products.
    // http://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
//        return new ResponseEntity<>(
//                e.getMessage(),
//                HttpStatus.NOT_FOUND
//        );
//    }
}

// ProductController -> ProductService
