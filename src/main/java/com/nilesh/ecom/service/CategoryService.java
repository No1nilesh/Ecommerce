package com.nilesh.ecom.service;

import com.nilesh.ecom.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
List<CategoryDTO> getAllCategory();
CategoryDTO getCategoryById(Long categoryId);
CategoryDTO createCategory(CategoryDTO categoryDTO);
CategoryDTO updateCategory(Long categoryId, CategoryDTO updatedCategoryDTO);
void deleteCategory(Long categoryId);
}
