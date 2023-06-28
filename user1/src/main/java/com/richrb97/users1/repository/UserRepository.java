package com.richrb97.users1.repository;

import com.richrb97.users1.document.RolCount;
import com.richrb97.users1.document.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    @Aggregation(pipeline = {
            "{$match: { age: { $gte: ?0, $lte: ?1 } }}"})
    Flux<User> findUsersByAgeRange(int minAge, int maxAge);

    @Aggregation(pipeline = {
            "{$match: { age: { $gte: ?0, $lte: ?1 } }}",
            "{$group: { _id: '$rol', count: { $sum: 1 } }}"
    })
    Flux<RolCount> aggregateUserCountByAgeRangeAndRole(int minAge, int maxAge);

    



}
