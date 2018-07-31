package tripmanagement.query

import org.springframework.cloud.contract.spec.*
[
    Contract.make {
        description("When a Get request with a UserId and Status=STARTED is made, the corresponding trip is returned")
        request {
            method 'GET'
            url '/api/v1/trip/user/4eaf29bc-3909-49d4-a104-3d17f68ba672/status/started'
        }
        response {
            status 200
            body("""
                [
                  {
                    "id": "f849769e-2534-84a6-d475-5c2d701343ab",
                    "userId": "4eaf29bc-3909-49d4-a104-3d17f68ba672",
                    "originAddress": "from some place over there",
                    "destinationAddress": "to this other place",
                    "status": "STARTED"
                  }
                ]
                """
            )
            headers {
                contentType(applicationJson())
            }
        }
    },
    Contract.make {
        description("When a Get request with a UserId and Status=CREATED is made, the corresponding trip is returned")
        request {
            method 'GET'
            url '/api/v1/trip/user/4eaf29bc-3909-49d4-a104-3d17f68ba672/status/created'
        }
        response {
            status 200
            body("""
                [
                  {
                    "id": "5b842415-9447-4b9b-85c6-2e1075214cc4",
                    "userId": "4eaf29bc-3909-49d4-a104-3d17f68ba672",
                    "originAddress": "from some place over there",
                    "destinationAddress": "to this other place",
                    "status": "CREATED"
                  }
                ]
                """
            )
            headers {
                contentType(applicationJson())
            }
        }
    },
    Contract.make {
        description("When a Get request with a UserId and Status=COMPLETED is made, the corresponding trip is returned")
        request {
            method 'GET'
            url '/api/v1/trip/user/4eaf29bc-3909-49d4-a104-3d17f68ba672/status/completed'
        }
        response {
            status 200
            body("""
                [
                  {
                    "id": "7a7d1e99-4823-4aa5-9d3b-2307e88cee0d",
                    "userId": "4eaf29bc-3909-49d4-a104-3d17f68ba672",
                    "originAddress": "from some place over there",
                    "destinationAddress": "to this other place",
                    "status": "COMPLETED"
                  }
                ]
                """
            )
            headers {
                contentType(applicationJson())
            }
        }
    },
    Contract.make {
        description("When a Get request with a UserId and Status=CANCELLED is made, the corresponding trip is returned")
        request {
            method 'GET'
            url '/api/v1/trip/user/4eaf29bc-3909-49d4-a104-3d17f68ba672/status/canceled'
        }
        response {
            status 200
            body("""
                [
                  {
                    "id": "7a7d1e99-4823-4aa5-9d3b-2307e88cee08",
                    "userId": "4eaf29bc-3909-49d4-a104-3d17f68ba672",
                    "originAddress": "from some place over there",
                    "destinationAddress": "to this other place",
                    "status": "CANCELED"
                  }
                ]
                """
            )
            headers {
                contentType(applicationJson())
            }
        }
    }
]
