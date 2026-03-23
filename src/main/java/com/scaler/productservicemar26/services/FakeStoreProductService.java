package com.scaler.productservicemar26.services;

import com.scaler.productservicemar26.dtos.FakeStoreProductDto;
import com.scaler.productservicemar26.models.Category;
import com.scaler.productservicemar26.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.PriorityOrdered;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private final PriorityOrdered priorityOrdered;
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, PriorityOrdered priorityOrdered) {
        this.restTemplate = restTemplate;
        this.priorityOrdered = priorityOrdered;
    }

    @Override
    public Product getProductById(long id) {
        //Implement FakeStore api.

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
                );

        //Convert FakeStoreProductDto to Product object.
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
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

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
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
