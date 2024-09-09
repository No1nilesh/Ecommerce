package com.nilesh.ecom.dto;

import com.nilesh.ecom.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long prodId;
    private String prodName;
    private String prodDesc;
    private BigDecimal price;
    private Float ratings;
    private String imageUrl;
    private Long categoryId;
}
