package com.ranjit.cabbooking.strategies;

import com.ranjit.cabbooking.model.Location;

public class DefaultPricingStrategy implements PricingStrategy {

    static private final Double PRICE_PER_KM = 11.0;

    @Override
    public Double getPrice(Location from, Location to) {
        return from.distance(to) * PRICE_PER_KM;
    }
}
