package com.nilesh.ecom.service.Impl;

import com.nilesh.ecom.dto.ProductDTO;
import com.nilesh.ecom.entity.Category;
import com.nilesh.ecom.entity.Product;
import com.nilesh.ecom.exception.ResourceNotFoundException;
import com.nilesh.ecom.mapper.ProductMapper;
import com.nilesh.ecom.repository.CategoryRepository;
import com.nilesh.ecom.repository.ProductRepository;
import com.nilesh.ecom.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found with the given Id " + productId));
        return ProductMapper.prodToDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.prodDtoToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.prodToDTO(savedProduct);
    }
}
