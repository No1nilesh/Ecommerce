package com.nilesh.ecom.mapper;

import com.nilesh.ecom.dto.ProductDTO;
import com.nilesh.ecom.entity.Category;
import com.nilesh.ecom.entity.Product;

public class ProductMapper {

    public static ProductDTO prodToDTO(Product product){
        return new ProductDTO(
                product.getProdId(),
                product.getProdName(),
                product.getProdDesc(),
                product.getPrice(),
                product.getRatings(),
                product.getImageUrl(),
                product.getCategoryId()
        );
    }

    public static Product prodDtoToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setProdId(productDTO.getProdId());
        product.setProdName(productDTO.getProdName());
        product.setProdDesc(productDTO.getProdDesc());
        product.setPrice(productDTO.getPrice());
        product.setRatings(productDTO.getRatings());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategoryId(productDTO.getCategoryId());
        return product;
    }

}
