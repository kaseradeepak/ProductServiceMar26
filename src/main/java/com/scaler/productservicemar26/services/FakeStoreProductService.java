package com.scaler.productservicemar26.services;

import com.scaler.productservicemar26.dtos.FakeStoreProductDto;
import com.scaler.productservicemar26.exceptions.ProductNotFoundException;
import com.scaler.productservicemar26.models.Category;
import com.scaler.productservicemar26.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        //Implement FakeStore api.
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
                );
//
//        System.out.println("Response body from fakestore: " + responseEntity.getBody());
//        System.out.println("Status Code from FakeStore: " + responseEntity.getStatusCode());

        //Convert FakeStoreProductDto to Product object.
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Product not found, please pass a valid id.");
        }

        return from(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        //Convert FakeStoreProductDto array into list.
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : responseEntity.getBody()) {
            products.add(from((fakeStoreProductDto)));
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto != null) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setImageUrl(fakeStoreProductDto.getImage());

            Category category = new Category();
            category.setTitle(fakeStoreProductDto.getCategory());
            product.setCategory(category);

            return product;
        }

        return null;
    }
}
