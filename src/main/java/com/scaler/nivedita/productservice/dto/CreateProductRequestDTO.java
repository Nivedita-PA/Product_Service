package com.scaler.nivedita.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    String title;
    String description;
    Double price;
    String image;
    String category;
}
