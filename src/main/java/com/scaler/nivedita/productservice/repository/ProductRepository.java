package com.scaler.nivedita.productservice.repository;

import com.scaler.nivedita.productservice.model.Product;
import com.scaler.nivedita.productservice.repository.Projection.ProductWithTitleAndId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
     Product save(Product p);
     List<Product> findAll();
     Product findProductById(Integer id);
     Product findByDescription(String description);
     Product deleteProductById(Integer id);

     @Query("select p from Product p where p.id= :id and p.title= :title")
     Product getProductFromDBByTitleandId(@Param("id") Integer id,@Param("title") String title);

     @Query("select p.title as title, p.id as id from Product p where p.price= :price")
     List<ProductWithTitleAndId> findTitleandIdOfAllProductsByPrice(@Param("price") String price);

     @Query(value = "select * from Product where id= :id",nativeQuery = true)
     Product myOwnSQLquerytoFetchProductFromDB(Integer id);
}
