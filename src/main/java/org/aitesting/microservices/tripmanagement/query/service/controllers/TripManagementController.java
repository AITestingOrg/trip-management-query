package org.aitesting.microservices.tripmanagement.query.service.controllers;

import java.util.List;
import java.util.UUID;
import org.aitesting.microservices.tripmanagement.common.exceptions.NotFoundException;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class TripManagementController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("trips")
    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    @GetMapping("trip/{id}")
    public Trip getTrip(@PathVariable("id") UUID id) throws NotFoundException {
        Trip trip = tripRepository.findOne(id);
        if (trip != null) {
            return trip;
        }
        throw new NotFoundException();
    }
}
