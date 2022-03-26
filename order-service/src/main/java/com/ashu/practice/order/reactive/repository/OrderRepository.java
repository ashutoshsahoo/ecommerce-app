package com.ashu.practice.order.reactive.repository;

import com.ashu.practice.order.domain.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface OrderRepository extends ReactiveMongoRepository<Order, ObjectId> {

}
