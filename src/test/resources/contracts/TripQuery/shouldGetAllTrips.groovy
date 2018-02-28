package TripQuery

import org.springframework.cloud.contract.spec.*

Contract.make {
    description("When a Get request for all the trips should get all the trips")
    request {
        method 'GET'
        url '/api/trips'
    }
    response {
        status 200
        body("""
            [
            \t{
            \t\t"id": "f849769e-2534-84a6-d475-5c2d701343ab",
            \t\t"userID": "123e4567-e89b-12d3-a456-426655440000",
            \t\t"originAddress": "from some place over there",
            \t\t"destinationAddress": "to this other place",
            \t\t"status": "STARTED"
            \t},
            \t{
            \t\t"id": "5b842415-9447-4b9b-85c6-2e1075214cc4",
            \t\t"userID": "123e4567-e89b-12d3-a456-426655440000",
            \t\t"originAddress": "from some place over there",
            \t\t"destinationAddress": "to this other place",
            \t\t"status": "CREATED"
            \t},
            \t{
            \t\t"id": "7a7d1e99-4823-4aa5-9d3b-2307e88cee0d",
            \t\t"userID": "123e4567-e89b-12d3-a456-426655440000",
            \t\t"originAddress": "from some place over there",
            \t\t"destinationAddress": "to this other place",
            \t\t"status": "COMPLETED"
            \t}
            ]
            """
        )
        headers {
            contentType(applicationJson())
        }
    }
}

