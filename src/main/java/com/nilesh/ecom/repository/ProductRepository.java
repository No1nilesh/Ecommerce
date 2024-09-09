package com.nilesh.ecom.repository;

import com.nilesh.ecom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
