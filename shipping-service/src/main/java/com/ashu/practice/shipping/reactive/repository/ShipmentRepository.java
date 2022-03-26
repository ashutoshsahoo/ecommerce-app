package com.ashu.practice.shipping.reactive.repository;

import com.ashu.practice.shipping.domain.Shipment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ShipmentRepository extends ReactiveMongoRepository<Shipment, ObjectId> {

}
