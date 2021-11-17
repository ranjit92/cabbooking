package com.ranjit.cabbooking.strategies;

import com.ranjit.cabbooking.model.Location;

public interface PricingStrategy {

    Double getPrice(Location from, Location to);
}
