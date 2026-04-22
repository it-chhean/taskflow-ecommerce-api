package com.taskflow.ecommerce.service.impl;

import com.taskflow.ecommerce.dto.request.CategoryRequest;
import com.taskflow.ecommerce.dto.response.CategoryResponse;
import com.taskflow.ecommerce.entities.Category;
import com.taskflow.ecommerce.exception.ResourceNotFoundException;
import com.taskflow.ecommerce.mapper.CategoryMapper;
import com.taskflow.ecommerce.repository.CategoryRepository;
import com.taskflow.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> getAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(categoryMapper::toCategoryResponse);
    }

    @Override
    public CategoryResponse updateCategory(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category",id));
        category.setSlug(request.slug());
        category.setName(request.name());
        category.setDescription(request.description());
        category.setTags(request.tags());
        category.setCreatedAt(LocalDateTime.now());
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        categoryRepository.delete(category);
    }
}
