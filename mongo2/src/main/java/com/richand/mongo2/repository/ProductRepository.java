package com.richand.mongo2.repository;

import com.richand.mongo2.document.AveragePriceResult;
import com.richand.mongo2.document.CategoryCountResult;
import com.richand.mongo2.document.Product;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    @Aggregation(pipeline = {
            "{$group: {_id: null, averagePrice: {$avg: '$price'}}}",
            "{$project: {_id: 0, averagePrice: 1}}"
    })
    Flux<AveragePriceResult> getAveragePrice();

    @Aggregation(pipeline = {
            "{$match: {price: {$gt: ?0}}}",
            "{$group: {_id: '$category', total: {$sum: 1}}}",
            "{$sort: {total: -1}}",
            "{$limit: ?1}"
    })
    Flux<CategoryCountResult> getCategoryCountsGreaterThan(double price, int limit);

    @Aggregation(pipeline = {
            "{$group: {_id: '$category', total: {$sum: 1}}}",
            "{$sort: {_id: 1}}"
    })
    Flux<CategoryCountResult> getCategoryCountsOrderedByCategory();
}