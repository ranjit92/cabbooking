package com.ranjit.cabbooking.database;

import com.ranjit.cabbooking.model.Cab;
import com.ranjit.cabbooking.model.Location;
import lombok.NonNull;

import java.util.*;

public class CabManager {

    Map<String, Cab> cabMap = new HashMap<>();

    public void registerCab(@NonNull Cab cab) {
        if (cabMap.containsKey(cab.getId())) {
            throw new RuntimeException("Cab Already Registered");
        }
        cabMap.put(cab.getId(), cab);
    }

    public Cab getCab(@NonNull String id) {
        if (!cabMap.containsKey(id)) {
            throw new RuntimeException("Cab doesn't exist");
        }
        return cabMap.get(id);
    }

    public void updateCabLocation(@NonNull String id, @NonNull Location newLocation) {
        if (!cabMap.containsKey(id)) {
            throw new RuntimeException("Cab Doesn't exist");
        }
        cabMap.get(id).setCurrentLocation(newLocation);
    }

    public void updateAvailability(@NonNull String id, boolean available) {
        if (!cabMap.containsKey(id)) {
            throw new RuntimeException("Cab Doesn't exist");
        }
        cabMap.get(id).setAvailable(available);
    }

    public List<Cab> getAvailableCabs(@NonNull Location fromLocation, @NonNull Double distance){
        List<Cab> cabs = new ArrayList<>();
        for(Cab cab : cabMap.values()){
            if(cab.isAvailable() && cab.getCurrentLocation().distance(fromLocation) <= distance){
                cabs.add(cab);
            }
        }
        return cabs;
    }


}
