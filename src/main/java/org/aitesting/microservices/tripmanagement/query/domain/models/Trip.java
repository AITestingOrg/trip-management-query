package org.aitesting.microservices.tripmanagement.query.domain.models;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.aitesting.microservices.tripmanagement.common.events.TripStatus;

public class Trip {
    @NotNull
    private UUID id;
    private UUID userId;
    private String originAddress;
    private String destinationAddress;

    private TripStatus status;

    public Trip(UUID id, UUID userId, String originAddress, String destinationAddress, TripStatus status) {
        this.id = id;
        this.userId = userId;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
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

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }
}
