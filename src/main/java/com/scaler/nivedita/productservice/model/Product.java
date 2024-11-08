package com.scaler.nivedita.productservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Product extends BaseModel implements Serializable {
    private String title;
    private String price;
    private String description;
    private String imageURL;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Category category;
}
