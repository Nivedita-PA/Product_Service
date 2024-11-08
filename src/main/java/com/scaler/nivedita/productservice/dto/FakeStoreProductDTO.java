package com.scaler.nivedita.productservice.dto;

import com.scaler.nivedita.productservice.model.Category;
import com.scaler.nivedita.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Integer id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;

    public Product toProduct(){
        Product p = new Product();
        p.setDescription(description);
        p.setPrice(price);
        p.setImageURL(image);
        p.setId(id);
        p.setTitle(title);
        Category c = new Category();
        c.setName(category);
        p.setCategory(c);
        return p;
    }
}
