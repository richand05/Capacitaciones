package com.richand.mongo2.service;

import com.richand.mongo2.document.AveragePriceResult;
import com.richand.mongo2.document.CategoryCountResult;
import com.richand.mongo2.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getAllProducts();
    Flux<AveragePriceResult> getAveragePrice();
    Mono<Product> createProduct(Product product);

    Flux<CategoryCountResult> getCategoryCountsGreaterThan(double price, int limit);

    Flux<CategoryCountResult> getCategoryCountsOrderedByCategory();
}