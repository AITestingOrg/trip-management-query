package tripmanagement.query

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a GET request for api/trip/{id} with invalid id should return 400")
    request {
        method 'GET'
        url '/api/trip/badIdString'
    }
    response {
        status 400
    }
}
