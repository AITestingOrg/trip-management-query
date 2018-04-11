package org.aitesting.microservices.tripmanagement.query.domain.eventhandlers;

import org.aitesting.microservices.tripmanagement.common.events.*;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripEventHandler {
    protected static final Logger LOG = LoggerFactory.getLogger(TripEventHandler.class);

    @Autowired
    private TripRepository tripRepository;

    public TripEventHandler() {}

    @EventHandler
    public void on(TripCreatedEvent event) {
        LOG.trace("Creating trip: {}", event.getId());
        tripRepository.save(new Trip(event.getId(), event.getUserId(),
                event.getOriginAddress(), event.getDestinationAddress(), event.getTripInvoice(), TripStatus.CREATED));
        LOG.info("Trip created: {}", event.getId());
    }

    @EventHandler
    public void on(TripCanceledEvent event) {
        LOG.trace("Cancelling Trip: {}", event.getId());
        Trip trip = tripRepository.findOne(event.getId());
        trip.setStatus(TripStatus.CANCELED);
        tripRepository.save(trip);
        LOG.info("Trip canceled: {}", event.getId());
    }

    @EventHandler
    public void on(TripStartedEvent event) {
        LOG.trace("Starting trip: {}", event.getId());
        Trip trip = tripRepository.findOne(event.getId());
        trip.setStatus(TripStatus.STARTED);
        tripRepository.save(trip);
        LOG.info("Trip started: {}", event.getId());
    }

    @EventHandler
    public void on(TripCompletedEvent event) {
        LOG.trace("Completing trip: {}", event.getId());
        Trip trip = tripRepository.findOne(event.getId());
        trip.setStatus(TripStatus.COMPLETED);
        tripRepository.save(trip);
        LOG.info("Trip completed: {}", event.getId());
    }

    @EventHandler
    public void on(TripUpdatedEvent event) {
        LOG.trace("Updating trip: {}", event.getId());
        Trip trip = tripRepository.findOne(event.getId());
        if (!trip.getOriginAddress().equals(event.getOriginAddress())) {
            LOG.info("Origin address updated: {}", event.getOriginAddress());
        }
        if (!trip.getDestinationAddress().equals(event.getDestinationAddress())) {
            LOG.info("Destination address updated: {}", event.getDestinationAddress());
        }
        trip.setStatus(TripStatus.UPDATED);
        trip.setOriginAddress(event.getOriginAddress());
        trip.setDestinationAddress(event.getDestinationAddress());
        trip.setTripInvoice(event.getTripInvoice());
        tripRepository.save(trip);
        LOG.info("Trip updated: {}", event.getId());
    }
}
