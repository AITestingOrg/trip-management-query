package org.aitesting.microservices.tripmanagement.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TripManagementQueryApplication.class, 
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Profile("test")
public class TripManagementQueryApplicationTests {

    protected static final Logger log = LoggerFactory.getLogger(TripManagementQueryApplicationTests.class);

    @Test
    public void contextLoads() {
    }
    
}