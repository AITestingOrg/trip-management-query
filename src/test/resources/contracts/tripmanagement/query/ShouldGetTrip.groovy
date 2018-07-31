package tripmanagement.query

import org.springframework.cloud.contract.spec.*
[
    Contract.make {
        description("When a Get request with a TripId is made, the corresponding trip is returned")
        request {
            method 'GET'
            url '/api/v1/trip/f849769e-2534-84a6-d475-5c2d701343ab'
        }
        response {
            status 200
            body(
                "id": "f849769e-2534-84a6-d475-5c2d701343ab",
                "userId": "4eaf29bc-3909-49d4-a104-3d17f68ba672",
                "originAddress": "from some place over there",
                "destinationAddress": "to this other place",
                "status": "STARTED"
            )
            headers {
                contentType(applicationJson())
            }
        }
    }
]