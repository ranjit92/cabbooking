package com.ranjit.cabbooking.model;

import lombok.NonNull;
import lombok.ToString;

enum TripStatus {
    IN_PROGRESS,
    FINISHED
}

@ToString
public class Trip {

    private final Cab cab;
    private final Rider rider;
    private final Location fromLocation;
    private final Location toLocation;
    private TripStatus status;
    private final Double price;

    public Trip(@NonNull Cab cab,
                @NonNull Rider rider,
                @NonNull Location fromLocation,
                @NonNull Location toLocation,
                @NonNull Double price) {

        this.cab = cab;
        this.rider = rider;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.price = price;
        this.status = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.status = TripStatus.FINISHED;
    }
}
