package org.aitesting.microservices.tests.unit;

import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_ID1;
import static org.aitesting.microservices.tests.helpers.TestConstants.USER_ID;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aitesting.microservices.tripmanagement.common.events.TripStatus;
import org.aitesting.microservices.tripmanagement.common.exceptions.NotFoundException;
import org.aitesting.microservices.tripmanagement.query.service.controllers.TripManagementController;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TripManagementControllerUnitTests {

    @InjectMocks
    private TripManagementController tripManagementController = new TripManagementController();

    @Mock
    private TripRepository tripRepository;

    @Test
    public void onGetTripsCall_FindAllIsCalled() {
        //arrange

        //act
        tripManagementController.getTrips();

        //assert
        verify(tripRepository, times(1)).findAll();
    }

    @Test
    public void onGetTripCall_FindOneIsCalled() {
        //arrange

        //act
        tripManagementController.getTrip(TRIP_ID1);

        //assert
        verify(tripRepository, times(1)).findOne(TRIP_ID1);
    }

    @Test
    public void ongetTripByUser_FindByUserIdCalled() {
        //arrange

        //act
        tripManagementController.getTripByUser(USER_ID);

        //assert
        verify(tripRepository, times(1)).findByUserId(USER_ID);
    }

    @Test
    public void ongetTripByUserAndStatus_FindByUserIdAndStatusIsCalled() {
        //arrange

        //act
        tripManagementController.getTripByUserAndStatus(USER_ID, "completed");

        //assert
        verify(tripRepository, times(1)).findByUserIdAndStatus(USER_ID, TripStatus.COMPLETED);
    }
}
