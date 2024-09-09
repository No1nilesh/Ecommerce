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
import java.util.List;



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
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::prodToDTO).toList();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.prodDtoToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        if (productDTO.getCategoryId() != null){
            Category category =  categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(()-> new ResourceNotFoundException("Category not Found With Id " + productDTO.getCategoryId()));
            category.getProdIds().add(savedProduct.getProdId());
            categoryRepository.save(category);
        }
        return ProductMapper.prodToDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long prodId, ProductDTO updatedProdDTO) {
        Product existingProd = productRepository.findById(prodId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found With Id " + prodId));
                existingProd.setProdName(updatedProdDTO.getProdName());
                existingProd.setProdDesc(updatedProdDTO.getProdDesc());
                existingProd.setPrice(updatedProdDTO.getPrice());
                existingProd.setRatings(updatedProdDTO.getRatings());
                existingProd.setImageUrl(updatedProdDTO.getImageUrl());
                // check if the Category needs to be updated.
                if (updatedProdDTO.getCategoryId() != null && !updatedProdDTO.getCategoryId().equals(existingProd.getCategoryId())){
                    existingProd.setCategoryId(updatedProdDTO.getCategoryId());
                }
                // Save the updated product back to the repository
                Product updatedProdObj = productRepository.save(existingProd);
                return ProductMapper.prodToDTO(updatedProdObj);
    }

    @Override
    public void deleteProduct(Long prodId) {
        Product prod = productRepository.findById(prodId)
                .orElseThrow(()-> new ResourceNotFoundException("Product Not Found With Id " + prodId));
        productRepository.deleteById(prodId);
    }
}
