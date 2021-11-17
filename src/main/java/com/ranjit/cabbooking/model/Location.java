package com.ranjit.cabbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Location {
    private final Double x;
    private final Double y;

    public Double distance(Location location) {
        return Math.sqrt
                (Math.pow((this.x - location.x), 2) +
                        (Math.pow((this.y - location.y), 2)));
    }

}
