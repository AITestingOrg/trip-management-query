package org.aitesting.microservices.tripmanagement.query.service.controllers;

import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api")
public class TripManagementController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("trips")
    public @ResponseBody
    List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    @GetMapping("trip/{id}")
    public @ResponseBody Trip getTrip(@PathVariable("id") UUID id) {
        return  tripRepository.findOne(id);
    }
}
