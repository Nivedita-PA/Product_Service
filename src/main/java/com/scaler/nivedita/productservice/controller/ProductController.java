package com.scaler.nivedita.productservice.controller;

import com.scaler.nivedita.productservice.dto.CreateProductRequestDTO;
import com.scaler.nivedita.productservice.exception.CategoryNotFoundException;
import com.scaler.nivedita.productservice.exception.ProductNotFoundException;
import com.scaler.nivedita.productservice.model.Product;
import com.scaler.nivedita.productservice.service.ProductService;
import com.scaler.nivedita.productservice.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
    @Cacheable(value = "product")
    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts(){
       List<ProductResponseDTO> dtoList = new ArrayList<>();
       List<Product> products = productService.getAllProducts();
       for(Product p: products){
           dtoList.add(convertProductToResponseDTO(p));
       }
       return dtoList;
    }
    @Cacheable(value = "product")
    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        if(product==null){
            throw new ProductNotFoundException("product does not exist");
            //return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        ProductResponseDTO response = convertProductToResponseDTO(product);
        return response;
    }

    private ProductResponseDTO convertProductToResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());
        dto.setImageURL(product.getImageURL());
        return dto;
    }

    @CachePut(value = "product",key = "#dto.title")
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO dto) throws CategoryNotFoundException {
       Product p = productService.createProduct(dto.getTitle(),dto.getDescription(),dto.getImage(),
               dto.getPrice(),dto.getCategory());
       return p;
    }

    @GetMapping("/products/{pageNo}/{pageSize}")
    public ResponseEntity<List<Product>> getPaginatedProduct(@PathVariable("pageNo") Integer pageNo,
                                                             @PathVariable("pageSize") Integer pageSize){
      Page<Product> productPage = productService.getPaginatedProduct(pageNo,pageSize);
        //System.out.println("product page: "+productPage);
      return ResponseEntity.ok(productPage.getContent());
    }
}
