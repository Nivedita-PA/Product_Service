package com.scaler.nivedita.productservice;

import com.scaler.nivedita.productservice.model.Category;
import com.scaler.nivedita.productservice.model.Product;
import com.scaler.nivedita.productservice.repository.CategoryRepository;
import com.scaler.nivedita.productservice.repository.ProductRepository;
import com.scaler.nivedita.productservice.repository.Projection.ProductWithTitleAndId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void testMyDB() {
        Product p = productRepository.getProductFromDBByTitleandId(4,"shoe");
        System.out.println(" Product is: " + p);
        List<ProductWithTitleAndId> ppp = productRepository.findTitleandIdOfAllProductsByPrice("1002.0");
        System.out.println(ppp);
        System.out.println("ppp size:  " + ppp.size());
        System.out.println("id: " + ppp.get(0).getId());
        System.out.println("desc: " + ppp.get(0).getDescription());
        System.out.println("title: " + ppp.get(0).getTitle());

        System.out.println();

        Product p2 = productRepository.myOwnSQLquerytoFetchProductFromDB(1);
        System.out.println("category is "+ p2.getCategory().getName());
        System.out.println("price is "+ p2.getPrice());

        System.out.println();

        List<Category> categoryList = categoryRepository.findAll();
        System.out.println(" Cat size is : " + categoryList.size());

        List<Product> products = categoryList.get(2).getProducts();
        System.out.println("title: " + products.get(1).getTitle());
    }

}
