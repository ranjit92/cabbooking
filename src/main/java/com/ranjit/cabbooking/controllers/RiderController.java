package com.ranjit.cabbooking.controllers;

import com.ranjit.cabbooking.database.RidersManager;
import com.ranjit.cabbooking.database.TripManager;
import com.ranjit.cabbooking.model.Location;
import com.ranjit.cabbooking.model.Rider;
import com.ranjit.cabbooking.model.Trip;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rider")
@AllArgsConstructor
public class RiderController {

    private RidersManager ridersManager;
    private TripManager tripManager;

    @PostMapping("/register")
    public ResponseEntity registerRider(final String riderId, final String riderName) {
        ridersManager.registerRider(new Rider(riderId, riderName));
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Trip>> getHistoryTrip(final String riderId) {
        return new ResponseEntity(tripManager.getTripHistory(riderId), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity bookTrip(final String riderId,
                                   final Double sourceX,
                                   final Double sourceY,
                                   final Double destX,
                                   final Double destY) {
        tripManager.bookRide(ridersManager.getRider(riderId),
                new Location(sourceX, sourceY),
                new Location(destX, destY));

        return new ResponseEntity(HttpStatus.OK);
    }

}
