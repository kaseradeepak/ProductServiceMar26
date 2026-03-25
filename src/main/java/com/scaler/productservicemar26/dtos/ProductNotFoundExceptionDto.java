package com.scaler.productservicemar26.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDto {
    private String message;
    private Long productId;
}
