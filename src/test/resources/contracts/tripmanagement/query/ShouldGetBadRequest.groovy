package tripmanagement.query

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When a GET request for api/trip/{id} with invalid id should return 400")
        request {
            method 'GET'
            url '/api/v1/trip/badIdString'
        }
        response {
            status 400
        }
    },
    Contract.make {
        description("When a GET request for api/trip/user/{userid} with invalid id should return 400")
        request {
            method 'GET'
            url '/api/v1/trip/user/badIdString'
        }
        response {
            status 400
        }
    },
    Contract.make {
        description("When a GET request for api/trip/user{id}/status/completed with invalid id should return 400")
        request {
            method 'GET'
            url '/api/v1/trip/user/badIdString/status/completed'
        }
        response {
            status 400
        }
    },
    Contract.make {
        description("When a GET request for api/trip/{id} with invalid id should return 400")
        request {
            method 'GET'
            url '/api/v1/trip/user/4eaf29bc-3909-49d4-a104-3d17f68ba672/status/badIdString'
        }
        response {
            status 400
        }
    }
]