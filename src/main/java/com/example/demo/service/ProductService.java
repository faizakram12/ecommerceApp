package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductCategoryResponse;
import com.example.demo.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    // Add Product
    public ProductResponse addProduct(ProductRequest request) {

        Product product = new Product();

        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategoryId(request.getCategoryId());

        Product savedProduct = productRepository.save(product);

        return convertToResponse(savedProduct);
    }

    // Get All Products
    public List<ProductResponse> getAllProducts() {

        List<Product> productList = productRepository.findAll();

        List<ProductResponse> responseList = new ArrayList<>();

        for (Product product : productList) {
            responseList.add(convertToResponse(product));
        }

        return responseList;
    }

    // Get Product By Id
    public ProductResponse getProductById(String id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        return convertToResponse(product);
    }

    // Get Products By Category
    public List<ProductResponse> getProductsByCategory(String categoryId) {

        List<Product> productList = productRepository.findByCategoryId(categoryId);

        List<ProductResponse> responseList = new ArrayList<>();

        for (Product product : productList) {
            responseList.add(convertToResponse(product));
        }

        return responseList;
    }

    // Update Product
    public ProductResponse updateProduct(String id, ProductRequest request) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategoryId(request.getCategoryId());

        Product updatedProduct = productRepository.save(product);

        return convertToResponse(updatedProduct);
    }

    // Delete Product
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    // Convert Product to ProductResponse
    private ProductResponse convertToResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setProductName(product.getProductName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCategoryId(product.getCategoryId());

        ProductCategory category = productCategoryRepository
                .findById(product.getCategoryId())
                .orElse(null);

        if (category != null) {

            ProductCategoryResponse categoryResponse = new ProductCategoryResponse();

            categoryResponse.setId(category.getId());
            categoryResponse.setCategoryName(category.getCategoryName());

            response.setCategory(categoryResponse);
        }

        return response;
    }

}