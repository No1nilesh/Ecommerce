package com.nilesh.ecom.service;

import com.nilesh.ecom.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
     ProductDTO getProductById(Long productId);

     ProductDTO createProduct(ProductDTO productDTO);
}
