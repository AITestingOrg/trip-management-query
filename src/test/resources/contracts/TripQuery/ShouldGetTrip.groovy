package TripQuery

import org.springframework.cloud.contract.spec.*

Contract.make {
    description("When a Get request with a TripID is made, the corresponding trip is returned")
    request {
        method 'GET'
        url '/api/trip/f849769e-2534-84a6-d475-5c2d701343ab'
    }
    response {
        status 200
        body(
            "id": "f849769e-2534-84a6-d475-5c2d701343ab",
            "userID": "123e4567-e89b-12d3-a456-426655440000",
            "originAddress": "from some place over there",
            "destinationAddress": "to this other place",
            "status": "STARTED"
        )
        headers {
            contentType(applicationJson())
        }
    }
}

