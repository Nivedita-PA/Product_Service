package com.scaler.nivedita.productservice.service;

import com.scaler.nivedita.productservice.exception.CategoryNotFoundException;
import com.scaler.nivedita.productservice.model.Category;
import com.scaler.nivedita.productservice.model.Product;
import com.scaler.nivedita.productservice.repository.CategoryRepository;
import com.scaler.nivedita.productservice.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{
     private final ProductRepository productRepository;
     private CategoryRepository categoryRepository;
     public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
         this.productRepository = productRepository;
         this.categoryRepository = categoryRepository;
     }
    @Override
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String image, Double price,String category) throws CategoryNotFoundException {
         Category fetchedCategory = categoryRepository.findByName(category);
         if(fetchedCategory==null){
             throw new CategoryNotFoundException("category does not exit");
         }
         Product productToBeSaved = new Product();
         productToBeSaved.setTitle(title);
         productToBeSaved.setDescription(description);
         productToBeSaved.setImageURL(image);
         productToBeSaved.setPrice(String.valueOf(price));
         productToBeSaved.setCategory(fetchedCategory);
         Product updatedProduct = productRepository.save(productToBeSaved);
         return updatedProduct;
    }

    @Override
    public Page<Product> getPaginatedProduct(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
         Page<Product> product = productRepository.findAll(pageable);
        return product;
    }
}
