package com.example.demo.repository;

import com.example.demo.model.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory,String> {

    ProductCategory findByCategoryName(String categoryName);
}
