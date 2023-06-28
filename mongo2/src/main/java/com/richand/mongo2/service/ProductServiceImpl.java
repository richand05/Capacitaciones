package com.richand.mongo2.service;

import com.richand.mongo2.document.AveragePriceResult;
import com.richand.mongo2.document.CategoryAveragePriceResult;
import com.richand.mongo2.document.CategoryCountResult;
import com.richand.mongo2.document.Product;
import com.richand.mongo2.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Flux<AveragePriceResult> getAveragePrice() {
        return productRepository.getAveragePrice();
    }
    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Flux<CategoryCountResult> getCategoryCountsGreaterThan(double price, int limit) {
        return productRepository.getCategoryCountsGreaterThan(price, limit);
    }



    @Override
    public Flux<CategoryAveragePriceResult> getCategoryAveragePrice(double priceThreshold) {
        return productRepository.getCategoryAveragePrice(priceThreshold);
    }
}