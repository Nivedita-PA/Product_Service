package com.scaler.nivedita.productservice.service;

import com.scaler.nivedita.productservice.exception.CategoryNotFoundException;
import com.scaler.nivedita.productservice.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    Product createProduct(String title, String description, String image,Double price,String category) throws CategoryNotFoundException;
    Page<Product> getPaginatedProduct(Integer pageNo, Integer pageSize);

}
