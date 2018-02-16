package org.aitesting.microservices.tripmanagement.query.domain.eventhandlers;

import org.aitesting.microservices.tripmanagement.common.TripCanceledEvent;
import org.aitesting.microservices.tripmanagement.common.TripCreatedEvent;
import org.aitesting.microservices.tripmanagement.common.TripStartedEvent;
import org.aitesting.microservices.tripmanagement.common.TripStatus;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TripEventHandler {
    protected static final Logger LOG = LoggerFactory.getLogger(TripEventHandler.class);

    @Autowired
    private TripRepository tripRepository;

    public TripEventHandler() {}

    @EventHandler
    public void on(TripCreatedEvent event){
        LOG.info("Trip created: ", event.getId());
        tripRepository.save(new Trip(event.getId(), event.getUserId(),
                event.getOriginAddress(), event.getDestinationAddress(), TripStatus.CREATED));
    }

    @EventHandler
    public void on(TripCanceledEvent event){
        LOG.info("Trip canceled: ", event.getId());
        Trip trip = tripRepository.findOne(event.getId());
        trip.cancelTrip();
        tripRepository.save(trip);
    }

    @EventHandler
    public void on(TripStartedEvent event){
        LOG.info("Trip started: ", event.getId());
        Trip trip = tripRepository.findOne(event.getId());
        trip.startTrip();
        tripRepository.save(trip);
    }
}
