package com.ranjit.cabbooking.strategies;

import com.ranjit.cabbooking.model.Cab;
import com.ranjit.cabbooking.model.Location;
import com.ranjit.cabbooking.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {

    Cab getMatchedCab(List<Cab> availableCabs, Rider rider, Location from, Location to);
}
