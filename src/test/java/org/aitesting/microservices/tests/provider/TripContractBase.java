package org.aitesting.microservices.tests.provider;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.aitesting.microservices.tripmanagement.common.events.TripStatus;
import org.aitesting.microservices.tripmanagement.query.TripManagementQueryApplication;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static org.aitesting.microservices.tests.helpers.TestConstants.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TripManagementQueryApplication.class)
public abstract class TripContractBase {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    TripRepository tripRepository;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        tripRepository.findAll();
        tripRepository.save(new Trip(TRIP_ID1, USER_ID, FROM, TO, TripStatus.STARTED));
        tripRepository.save(new Trip(TRIP_ID2, USER_ID, FROM, TO, TripStatus.CREATED));
        tripRepository.save(new Trip(TRIP_ID3, USER_ID, FROM, TO, TripStatus.COMPLETED));
    }

    @After
    public void teardown() {
        tripRepository.deleteAll();
    }
}

