package org.aitesting.microservices.tripmanagement.query.service.repositories;

import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TripRepository  extends MongoRepository<Trip, UUID>{
}
