package com.richand.mongo2.repository;

import com.richand.mongo2.document.AveragePriceResult;
import com.richand.mongo2.document.CategoryAveragePriceResult;
import com.richand.mongo2.document.CategoryCountResult;
import com.richand.mongo2.document.Product;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
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

    @Aggregation(pipeline = {
            "{$match: {price: {$gt: ?0}}}",
            "{$group: {_id: '$category', averagePrice: {$avg: '$price'}}}"
    })
    Flux<CategoryAveragePriceResult> getCategoryAveragePrice(double priceThreshold);
}