package com.scaler.nivedita.productservice.repository;

import com.scaler.nivedita.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
     Category findByName(String name);
     List<Category> findAll();

//     @Query(value = "select c from Category c LEFT JOIN FETCH c.products")
//     Category myOwnSQLForGettingProductFromDBByIdWithoutN(Integer id);
}
