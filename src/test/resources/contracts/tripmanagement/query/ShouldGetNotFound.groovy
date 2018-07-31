package tripmanagement.query

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When a Get request with a TripID is made, but trip not in db, should return 404")
        request {
            method 'GET'
            url '/api/v1/trip/049769e-2534-84a6-d475-5c2d701343ab'
        }
        response {
            status 404
        }
    },
    Contract.make {
        description("When a Get request with a UserID is made, but trip not in db, should return 404")
        request {
            method 'GET'
            url '/api/v1/trip/user/0eaf29bc-3909-49d4-a104-3d17f68ba672'
        }
        response {
            status 404
        }
    },
    Contract.make {
        description("When a Get request with a UserID is made, but trip not in db, should return 404")
        request {
            method 'GET'
            url '/api/v1/trip/user/0eaf29bc-3909-49d4-a104-3d17f68ba672/status/completed'
        }
        response {
            status 404
        }
    }
]