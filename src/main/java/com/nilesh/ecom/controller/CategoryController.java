package com.nilesh.ecom.controller;

import com.nilesh.ecom.dto.CategoryDTO;
import com.nilesh.ecom.entity.Category;
import com.nilesh.ecom.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<CategoryDTO>>  getAllCategories(){
        List<CategoryDTO> categoryDTO = categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping("/api/admin/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategoryDTO =  categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoryDTO);
    }

    @PutMapping("/api/admin/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable(value = "id") Long  categoryId ,@RequestBody CategoryDTO categoryDTO){
        CategoryDTO updatedCategoryDTO =  categoryService.updateCategory(categoryId, categoryDTO);
        return ResponseEntity.ok(updatedCategoryDTO);
    }

    @DeleteMapping("/api/admin/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(value = "id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category Deleted Successfully");
    }
}
