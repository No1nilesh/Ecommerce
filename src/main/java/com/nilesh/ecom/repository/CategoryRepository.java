package com.nilesh.ecom.repository;

import com.nilesh.ecom.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
