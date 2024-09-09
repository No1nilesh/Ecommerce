package com.nilesh.ecom.service;

import com.nilesh.ecom.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     ProductDTO getProductById(Long productId);
     List<ProductDTO> getAllProducts();
     ProductDTO createProduct(ProductDTO productDTO);
     ProductDTO updateProduct(Long prodId, ProductDTO updatedProdDTO);
     void deleteProduct(Long prodId);
}
