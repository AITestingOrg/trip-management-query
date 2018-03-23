package org.aitesting.microservices.tripmanagement.query.service.controllers;

import java.util.List;
import java.util.UUID;

import org.aitesting.microservices.tripmanagement.common.events.TripStatus;
import org.aitesting.microservices.tripmanagement.common.exceptions.NotFoundException;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TripManagementController {

    private static final Logger logger = LoggerFactory.getLogger(TripManagementController.class);

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("trips")
    public ResponseEntity<List<Trip>> getTrips() {
        logger.info(String.format("Request all trips"));
        return new ResponseEntity<>(tripRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("trip/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable("id") UUID id) {
        logger.info(String.format("Request for trip by ID: %s", id));
        Trip trip = tripRepository.findOne(id);
        if (trip != null) {
            logger.trace(String.format("Found trip by ID: %s", id));
            return new ResponseEntity<>(trip, HttpStatus.OK);
        }
        logger.trace(String.format("No trips found by ID: %s", id));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("trip/user/{userId}")
    public ResponseEntity<List<Trip>> getTripByUser(@PathVariable("userId") UUID userId) {
        logger.info(String.format("Request for trips from user: %s", userId));
        List<Trip> trips = tripRepository.findByUserId(userId);
        if (trips != null && trips.size() > 0) {
            logger.trace(String.format("Found trip for user: %s", userId));
            return new ResponseEntity<>(trips, HttpStatus.OK);
        }
        logger.trace(String.format("No trips found for user: %s", userId));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("trip/user/{userId}/status/{status}")
    public ResponseEntity<List<Trip>> getTripByUserAndStatus(@PathVariable("userId") UUID userId,
                                                             @PathVariable("status") String status) {
        logger.info(String.format("Request for trips from user: %s with status: %s", userId, status));
        TripStatus tripStatus;
        try {
            tripStatus = TripStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.trace(String.format("Bad argument status: %s", status));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Trip> trips = tripRepository.findByUserIdAndStatus(userId, tripStatus);
        if (trips != null && trips.size() > 0) {
            logger.trace(String.format("Found trip for user: %s with status: %s", userId, status));
            return new ResponseEntity<>(trips, HttpStatus.OK);
        }
        logger.trace(String.format("No trips found for user: %s with status: %s", userId, status));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
