package org.aitesting.microservices.tripmanagement.query.service.controllers;

import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public Trip getTrip(@PathVariable("id") UUID id) {
        return tripRepository.findOne(id);
    }
}
