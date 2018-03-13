package org.aitesting.microservices.tripmanagement.query.service.repositories;

import java.util.UUID;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository  extends MongoRepository<Trip, UUID> {
}
