package org.aitesting.microservices.tests.provider;

import static org.aitesting.microservices.tests.helpers.TestConstants.FROM;
import static org.aitesting.microservices.tests.helpers.TestConstants.TO;
import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_ID1;
import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_ID2;
import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_ID3;
import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_ID4;
import static org.aitesting.microservices.tests.helpers.TestConstants.TRIP_INVOICE;
import static org.aitesting.microservices.tests.helpers.TestConstants.USER_ID;

import org.aitesting.microservices.tripmanagement.common.events.TripStatus;
import org.aitesting.microservices.tripmanagement.query.TripManagementQueryApplication;
import org.aitesting.microservices.tripmanagement.query.domain.models.Trip;
import org.aitesting.microservices.tripmanagement.query.service.repositories.TripRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TripManagementQueryApplication.class, 
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Profile("test")
public abstract class TripContractBase {
    
    protected static final Logger log = LoggerFactory.getLogger(TripContractBase.class);

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    TripRepository tripRepository;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        tripRepository.findAll();
        tripRepository.save(new Trip(TRIP_ID1, USER_ID, FROM, TO, TRIP_INVOICE, TripStatus.STARTED));
        tripRepository.save(new Trip(TRIP_ID2, USER_ID, FROM, TO, TRIP_INVOICE, TripStatus.CREATED));
        tripRepository.save(new Trip(TRIP_ID3, USER_ID, FROM, TO, TRIP_INVOICE, TripStatus.COMPLETED));
        tripRepository.save(new Trip(TRIP_ID4, USER_ID, FROM, TO, TRIP_INVOICE, TripStatus.CANCELED));
    }

    @After
    public void teardown() {
        tripRepository.deleteAll();
    }
}

