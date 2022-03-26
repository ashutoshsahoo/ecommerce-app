package com.ashu.practice.inventory.reactive.repository;

import com.ashu.practice.inventory.domain.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, ObjectId> {
}
