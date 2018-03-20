package tripmanagement.query

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a GET request for api/trip/{id} with invalid id should return 400")
    request {
        method 'GET'
        url '/api/v1/trip/badIdString'
    }
    response {
        status 400
    }
}

Contract.make {
    description("When a GET request for api/trip/user/{userid} with invalid id should return 400")
    request {
        method 'GET'
        url '/api/v1/trip/user/badIdString'
    }
    response {
        status 400
    }
}

Contract.make {
    description("When a GET request for api/trip/user{id}/status/completed with invalid id should return 400")
    request {
        method 'GET'
        url '/api/v1/trip/user/badIdString/status/completed'
    }
    response {
        status 400
    }
}

Contract.make {
    description("When a GET request for api/trip/{id} with invalid id should return 400")
    request {
        method 'GET'
        url '/api/v1/trip/user/123e4567-e89b-12d3-a456-426655440000/status/badIdString'
    }
    response {
        status 400
    }
}
