package tripmanagement.query

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When a Get request with a TripID is made, but trip not in db, should return 404")
        request {
            method 'GET'
            url '/api/v1/trip/123e4567-e89b-12d3-a456-426655440000'
        }
        response {
            status 404
        }
    },
    Contract.make {
        description("When a Get request with a UserID is made, but trip not in db, should return 404")
        request {
            method 'GET'
            url '/api/v1/trip/user/123e4567-e89b-12d3-a456-426655440001'
        }
        response {
            status 404
        }
    },
    Contract.make {
        description("When a Get request with a UserID is made, but trip not in db, should return 404")
        request {
            method 'GET'
            url '/api/v1/trip/user/123e4567-e89b-12d3-a456-426655440001/status/completed'
        }
        response {
            status 404
        }
    }
]