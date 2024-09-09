package com.nilesh.ecom.controller;


import com.nilesh.ecom.dto.ProductDTO;
import com.nilesh.ecom.exception.ResourceNotFoundException;
import com.nilesh.ecom.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {
    private ProductService productService;

    // GET Product by ID
    @GetMapping(path = "/api/public/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws ResourceNotFoundException {
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    //GET All Product
    @GetMapping(path = "/api/public/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOS = productService.getAllProducts();
        return ResponseEntity.ok(productDTOS);
    }

    // CREATE Product
    @PostMapping("/api/admin/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    // UPDATE Product
    @PutMapping("/api/admin/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(name = "id") Long prodId, @RequestBody ProductDTO updatedProdDTO){
        ProductDTO updateProd = productService.updateProduct(prodId, updatedProdDTO);
        return ResponseEntity.ok(updatedProdDTO);
    }

    // DELETE Product
    @DeleteMapping("/api/admin/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") Long prodId){
        productService.deleteProduct(prodId);
        return ResponseEntity.ok("Product Deleted");
    }


}
