package com.nilesh.ecom.service.Impl;

import com.nilesh.ecom.dto.CategoryDTO;
import com.nilesh.ecom.entity.Category;
import com.nilesh.ecom.exception.ResourceNotFoundException;
import com.nilesh.ecom.mapper.CategoryMapper;
import com.nilesh.ecom.repository.CategoryRepository;
import com.nilesh.ecom.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> allCategories =  categoryRepository.findAll();
        return allCategories.stream().map(CategoryMapper::categoryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category Not Found with Id "+ categoryId));
        return CategoryMapper.categoryToDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.categoryDtoToEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.categoryToDTO(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO updateCategoryDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category Not Found with the Id "+ categoryId));

                category.setCategoryName(updateCategoryDTO.getCategoryName());
                Category updateCategoryObj =categoryRepository.save(category);
        return CategoryMapper.categoryToDTO(updateCategoryObj);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category Not Found with the Id "+ categoryId));
        categoryRepository.deleteById(categoryId);
    }


}
