package TripQuery

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description("When a Get request with a TripID is made, the corresponding trip is returned")
    request {
        method 'GET'
        url '/api/trip/123e4567-e89b-12d3-a456-426655440000'
    }
    response {
        status 404
        headers {
        }
    }
}

