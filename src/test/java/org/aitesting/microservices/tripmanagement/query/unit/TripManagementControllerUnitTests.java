package org.aitesting.microservices.tripmanagement.query.unit;

import org.aitesting.microservices.tripmanagement.query.service.controllers.TripManagementController;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TripManagementControllerUnitTests {

    @InjectMocks
    TripManagementController tripManagementController = new TripManagementController();

    @Mock
    TripRepository tripRepository;

    @Test
    public void onGetTripsCall_FindAllIsCalled(){
        //arrange

        //act
        tripManagementController.getTrips();

        //assert
        verify(tripRepository, times(1)).findAll();
    }

    @Test
    public void onGetTripCall_FindOneIsCalled(){
        //arrange
        UUID tripId = UUID.randomUUID();

        //act
        tripManagementController.getTrip(tripId);

        //assert
        verify(tripRepository, times(1)).findOne(tripId);
    }
}
