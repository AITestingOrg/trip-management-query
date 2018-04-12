package org.aitesting.microservices.tests.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;
import org.aitesting.microservices.tripmanagement.common.events.*;
import org.aitesting.microservices.tripmanagement.query.domain.eventhandlers.TripEventHandler;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TripEventHandlerUnitTests {

    @InjectMocks
    private TripEventHandler tripEventHandler = new TripEventHandler();

    @Mock
    private static TripRepository tripRepository;

    @Mock
    private static TripCreatedEvent tripCreatedEvent;

    @Mock
    private TripCanceledEvent tripCanceledEvent;

    @Mock
    private TripStartedEvent tripStartedEvent;

    @Mock
    private TripCompletedEvent tripCompletedEvent;

    @Mock
    private static TripUpdatedEvent tripUpdatedEvent;

    @Mock
    private static Trip trip;

    @Before
    public void setup() {
        when(tripRepository.findOne(any(UUID.class))).thenReturn(trip);
    }

    @Test
    public void onTripCreatedEvent_SaveIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripCreatedEvent);

        //assert
        verify(tripRepository, times(1)).save(any(Trip.class));
    }

    @Test
    public void onTripCanceledEvent_FindOneIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripStartedEvent);

        //assert
        verify(tripRepository, times(1)).findOne(any(UUID.class));
    }

    @Test
    public void onTripCanceledEvent_SaveIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripCanceledEvent);

        //assert
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    public void onTripStartedEvent_SaveIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripStartedEvent);

        //assert
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    public void onTripCompletedEvent_SaveIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripCompletedEvent);

        //assert
        verify(tripRepository, times(1)).save(trip);
    }

    @Test
    public void onTripUpdatedEvent_FindOneIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripUpdatedEvent);

        //assert
        verify(tripRepository, times(1)).findOne(any(UUID.class));
    }

    @Test
    public void onTripUpdatedEvent_SaveIsCalled() {
        //arrange

        //act
        tripEventHandler.on(tripUpdatedEvent);

        //assert
        verify(tripRepository, times(1)).save(trip);
    }
}
