package com.example.demo.controller;

import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add Product
    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    // Get All Products
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get Product By Id
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    // Get Products By Category
    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> getProductsByCategory(@PathVariable String categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    // Update Product
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable String id,
                                         @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "Product deleted successfully.";
    }

}