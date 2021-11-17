package com.ranjit.cabbooking.strategies;

import com.ranjit.cabbooking.model.Cab;
import com.ranjit.cabbooking.model.Location;
import com.ranjit.cabbooking.model.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{
    @Override
    public Cab getMatchedCab(List<Cab> availableCabs, Rider rider, Location from, Location to) {
        return availableCabs.stream()
                .filter(cab_ -> cab_ != null)
                .findAny().orElseThrow(() -> new RuntimeException("Not able to match any cab"));
    }
}
