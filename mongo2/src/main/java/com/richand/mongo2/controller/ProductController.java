package com.richand.mongo2.controller;

import com.richand.mongo2.document.AveragePriceResult;
import com.richand.mongo2.document.CategoryAveragePriceResult;
import com.richand.mongo2.document.CategoryCountResult;
import com.richand.mongo2.document.Product;
import com.richand.mongo2.repository.ProductRepository;
import com.richand.mongo2.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product) {
        return productService.createProduct(product)
                .map(createdProduct -> ResponseEntity.status(HttpStatus.CREATED).body(createdProduct));
    }

    @GetMapping("/products")
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/average-price")
    public Flux<AveragePriceResult> getAveragePrice() {
        return productService.getAveragePrice();
    }
    @GetMapping("/products/category-counts")
    public Flux<CategoryCountResult> getCategoryCountsGreaterThan(@RequestParam double price, @RequestParam int limit) {
        return productService.getCategoryCountsGreaterThan(price, limit);
    }


    @GetMapping("/products/category-average-price")
    public Flux<CategoryAveragePriceResult> getCategoryAveragePrice(@RequestParam double priceThreshold) {
        return productService.getCategoryAveragePrice(priceThreshold);
    }
}