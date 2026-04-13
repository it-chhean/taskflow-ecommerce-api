package com.taskflow.ecommerce.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.ecommerce.dto.request.CategoryRequest;
import com.taskflow.ecommerce.dto.response.CategoryResponse;
import com.taskflow.ecommerce.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> create(
            @Valid @RequestBody CategoryRequest categoryRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(categoryService.createCategory(categoryRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAll(
            @PageableDefault(size = 10, sort = "id")
            @Valid Pageable pageable ) {
            return ResponseEntity.ok(categoryService.getAll(pageable));
    }

    @PutMapping("/{id}") 
    public ResponseEntity<CategoryResponse> update(
            @PathVariable Integer id,
            @RequestBody CategoryRequest categoryRequest
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequest));
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
