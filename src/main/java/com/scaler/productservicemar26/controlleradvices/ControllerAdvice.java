package com.scaler.productservicemar26.controlleradvices;

import com.scaler.productservicemar26.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicemar26.exceptions.ProductNotFoundException;
import com.scaler.productservicemar26.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Global Exception Handler.
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException ex) {
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setProductId(ex.getProductId());
        dto.setMessage(ex.getMessage());

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(CategoryNotFoundException.class)
//    public ResponseEntity<DTO> handleProductNotFoundException(ProductNotFoundException ex) {
//        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
//        dto.setProductId(ex.getProductId());
//        dto.setMessage(ex.getMessage());
//
//        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
//    }
}
