package com.scaler.nivedita.productservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category extends  BaseModel implements Serializable {
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Product> products;
}
