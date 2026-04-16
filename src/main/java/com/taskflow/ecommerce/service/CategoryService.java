package com.taskflow.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.taskflow.ecommerce.dto.request.CategoryRequest;
import com.taskflow.ecommerce.dto.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest categoryRequest);
    CategoryResponse getCategoryById(Integer id);
    Page<CategoryResponse> getAll(Pageable pageable);
    CategoryResponse updateCategory(Integer id, CategoryRequest categoryRequest);
    void delete(Integer id);

}
