package com.ranjit.cabbooking.database;

import com.ranjit.cabbooking.model.Cab;
import com.ranjit.cabbooking.model.Location;
import com.ranjit.cabbooking.model.Rider;
import com.ranjit.cabbooking.model.Trip;
import com.ranjit.cabbooking.strategies.CabMatchingStrategy;
import com.ranjit.cabbooking.strategies.PricingStrategy;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripManager {
    private static final Double AREA = 10.0;
    Map<String, List<Trip>> trips = new HashMap<>();

    private PricingStrategy pricingStrategy;
    private CabMatchingStrategy cabMatchingStrategy;
    private CabManager cabManager;

    public TripManager(final PricingStrategy pricingStrategy,
                       final CabMatchingStrategy cabMatchingStrategy,
                       final CabManager cabManager) {
        this.cabManager = cabManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public void bookRide(Rider rider, Location fromLocation, Location toLocation) {
        List<Cab> availableCabs = cabManager.getAvailableCabs(fromLocation, AREA);
        Double price = pricingStrategy.getPrice(fromLocation, toLocation);
        Cab matchedCab = cabMatchingStrategy.getMatchedCab(availableCabs, rider, fromLocation, toLocation);

        Trip trip = new Trip(matchedCab, rider, fromLocation, toLocation, price);
        matchedCab.setCurrentTrip(trip);
        if (trips.containsKey(rider.getId())) {
            trips.get(rider.getId()).add(trip);
        } else {
            List<Trip> tripList = new ArrayList<>();
            tripList.add(trip);
            trips.put(rider.getId(), tripList);
        }

    }

    public List<Trip> getTripHistory(@NonNull String id) {
        if (!trips.containsKey(id)) {
            throw new RuntimeException("Rider Doesn't exist");
        }
        return trips.get(id);
    }

    public void endTrip(@NonNull Cab cab) {
        if (cab.getCurrentTrip() == null) {
            throw new RuntimeException("No trip found");
        }
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
