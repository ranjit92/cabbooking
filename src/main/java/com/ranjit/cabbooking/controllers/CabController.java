package com.ranjit.cabbooking.controllers;

import com.ranjit.cabbooking.database.CabManager;
import com.ranjit.cabbooking.database.RidersManager;
import com.ranjit.cabbooking.database.TripManager;
import com.ranjit.cabbooking.model.Cab;
import com.ranjit.cabbooking.model.Location;
import com.ranjit.cabbooking.model.Rider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/cab")
public class CabController {

    private CabManager cabManager;
    private TripManager tripManager;

    @PostMapping("/register")
    public ResponseEntity registerCab(final String cabId, final String driverName) {
        cabManager.registerCab(new Cab(cabId, driverName));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/location")
    public ResponseEntity updateCabLocation(final String cabId, final Double x, final Double y) {
        cabManager.updateCabLocation(cabId, new Location(x, y));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/availability")
    public ResponseEntity updateCabAvailability(final String cabId, final boolean isAvailable) {
        cabManager.updateAvailability(cabId, isAvailable);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/end/trip")
    public ResponseEntity endTrip(final String cabId){
        tripManager.endTrip(cabManager.getCab(cabId));
        return new ResponseEntity(HttpStatus.OK);
    }
}
