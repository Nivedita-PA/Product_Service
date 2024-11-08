package com.scaler.nivedita.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDTO {
    String message;
    String code;
}
