package org.aitesting.microservices.tripmanagement.query.domain.models;


import org.aitesting.microservices.tripmanagement.common.TripStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Document(collection = "trips")
public class Trip {
    @NotNull
    private UUID id;
    private UUID userID;
    private String originAddress;
    private String destinationAddress;

    private TripStatus status;

    public Trip(UUID id, UUID userID, String originAddress, String destinationAddress, TripStatus status) {
        this.id = id;
        this.userID = userID;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }
    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }
}
