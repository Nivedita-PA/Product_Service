package com.scaler.nivedita.productservice.dto;

import com.scaler.nivedita.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    private Integer id;
    private String title;
    private String price;
    private String description;
    private String imageURL;
    private Category category;
}
