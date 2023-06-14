package com.richrb97.product1.controller;

import com.richrb97.product1.dto.ProductDto;
import com.richrb97.product1.entity.Product;
import com.richrb97.product1.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        List<ProductDto> productDtoList = productService.getAllProducts();
        return ResponseEntity.ok().body(productDtoList);
    }

    @PostMapping("/register")
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductDto productDto){
        String register= productService.createProduct(productDto);
        System.out.println(register);
        return ResponseEntity.accepted().build();
    }

}