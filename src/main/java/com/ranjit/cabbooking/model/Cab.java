package com.ranjit.cabbooking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class Cab {
    String id;
    String driverName;

    public Cab(String id, String name){
        this.id = id;
        this.driverName = name;
    }
    @Setter boolean isAvailable;
    @Setter Location currentLocation;
    @Setter Trip currentTrip;
}
