package com.scaler.nivedita.productservice.advise;

import com.scaler.nivedita.productservice.dto.ErrorDTO;
import com.scaler.nivedita.productservice.exception.CategoryNotFoundException;
import com.scaler.nivedita.productservice.exception.ProductNotFoundException;
import com.scaler.nivedita.productservice.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception){
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some status code");
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleCategoryNotFoundException(CategoryNotFoundException exception){
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some status code");
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
    }
}
