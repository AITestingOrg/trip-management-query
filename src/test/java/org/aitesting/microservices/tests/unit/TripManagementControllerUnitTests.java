package org.aitesting.microservices.tests.unit;

import org.aitesting.microservices.exceptions.NotFoundException;
import org.aitesting.microservices.tripmanagement.query.service.controllers.TripManagementController;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_ID1;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TripManagementControllerUnitTests {

    @InjectMocks
    private TripManagementController tripManagementController = new TripManagementController();

    @Mock
    private TripRepository tripRepository;

    @Test
    public void onGetTripsCall_FindAllIsCalled(){
        //arrange

        //act
        tripManagementController.getTrips();

        //assert
        verify(tripRepository, times(1)).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void onGetTripCall_FindOneIsCalled() throws NotFoundException {
        //arrange

        //act
        tripManagementController.getTrip(TRIP_ID1);

        //assert
        verify(tripRepository, times(1)).findOne(TRIP_ID1);
    }
}
