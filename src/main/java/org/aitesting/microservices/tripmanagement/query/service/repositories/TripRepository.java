package org.aitesting.microservices.tripmanagement.query.service.repositories;

import java.util.List;
import java.util.UUID;

import org.aitesting.microservices.tripmanagement.common.events.TripStatus;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository  extends MongoRepository<Trip, UUID> {
    List<Trip> findByUserId(UUID userId);

    List<Trip> findByUserIdAndStatus(UUID userId, TripStatus status);
}
