package com.example.demo.controller;

import com.example.demo.request.ProductCategoryRequest;
import com.example.demo.response.ProductCategoryResponse;
import com.example.demo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    // Add Category
    @PostMapping
    public ProductCategoryResponse addCategory(@RequestBody ProductCategoryRequest request) {
        return productCategoryService.addCategory(request);
    }

    // Get All Categories
    @GetMapping
    public List<ProductCategoryResponse> getAllCategories() {
        return productCategoryService.getAllCategories();
    }

    // Get Category By Id
    @GetMapping("/{id}")
    public ProductCategoryResponse getCategoryById(@PathVariable String id) {
        return productCategoryService.getCategoryById(id);
    }

    // Update Category
    @PutMapping("/{id}")
    public ProductCategoryResponse updateCategory(@PathVariable String id,
                                                  @RequestBody ProductCategoryRequest request) {
        return productCategoryService.updateCategory(id, request);
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable String id) {
        productCategoryService.deleteCategory(id);
        return "Category deleted successfully.";
    }

}