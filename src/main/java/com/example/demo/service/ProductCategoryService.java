package com.example.demo.service;

import com.example.demo.model.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.request.ProductCategoryRequest;
import com.example.demo.response.ProductCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    // Add Category
    public ProductCategoryResponse addCategory(ProductCategoryRequest request) {

        ProductCategory category = new ProductCategory();

        category.setCategoryName(request.getCategoryName());

        ProductCategory savedCategory = productCategoryRepository.save(category);

        return convertToResponse(savedCategory);
    }

    // Get All Categories
    public List<ProductCategoryResponse> getAllCategories() {

        List<ProductCategory> categoryList = productCategoryRepository.findAll();

        List<ProductCategoryResponse> responseList = new ArrayList<>();

        for (ProductCategory category : categoryList) {
            responseList.add(convertToResponse(category));
        }

        return responseList;
    }

    // Get Category By Id
    public ProductCategoryResponse getCategoryById(String id) {

        ProductCategory category = productCategoryRepository.findById(id).orElse(null);

        if (category == null) {
            return null;
        }

        return convertToResponse(category);
    }

    // Update Category
    public ProductCategoryResponse updateCategory(String id, ProductCategoryRequest request) {

        ProductCategory category = productCategoryRepository.findById(id).orElse(null);

        if (category == null) {
            return null;
        }

        category.setCategoryName(request.getCategoryName());

        ProductCategory updatedCategory = productCategoryRepository.save(category);

        return convertToResponse(updatedCategory);
    }

    // Delete Category
    public void deleteCategory(String id) {
        productCategoryRepository.deleteById(id);
    }

    // Convert Model to Response
    private ProductCategoryResponse convertToResponse(ProductCategory category) {

        ProductCategoryResponse response = new ProductCategoryResponse();

        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());

        return response;
    }

}