package com.scaler.nivedita.productservice.service;

import com.scaler.nivedita.productservice.dto.FakeStoreProductDTO;
import com.scaler.nivedita.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Integer id) {
        //1. call fake store
        //2.
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/"+ id,
                FakeStoreProductDTO.class);
        if(response.getStatusCode().equals(HttpStatus.OK)){
            return null;
        }
        FakeStoreProductDTO fakeStoreResponseDTO = response.getBody();
        return fakeStoreResponseDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreProductDTO[] response = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        for(FakeStoreProductDTO dto: response){
            products.add(dto.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title, String description, String image, Double price,String category) {
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setImage(image);
        requestBody.setPrice(String.valueOf(price));
        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",requestBody,FakeStoreProductDTO.class);
        return response.toProduct();
    }

    @Override
    public Page<Product> getPaginatedProduct(Integer pageSize, Integer pageNo) {
        return null;
    }

}
