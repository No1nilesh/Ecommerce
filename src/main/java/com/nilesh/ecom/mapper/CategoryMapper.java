package com.nilesh.ecom.mapper;

import com.nilesh.ecom.dto.CategoryDTO;
import com.nilesh.ecom.entity.Category;

public class CategoryMapper {
    public static CategoryDTO categoryToDTO(Category category){
        return new CategoryDTO(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getProdIds()
        );
    }

    public static Category categoryDtoToEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setProdIds(categoryDTO.getProdIds());
        return category;
    }
}
