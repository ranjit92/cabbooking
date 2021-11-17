package com.ranjit.cabbooking.database;

import com.ranjit.cabbooking.model.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {

    Map<String, Rider> ridersMap = new HashMap<>();

    public void registerRider(@NonNull final Rider rider) {
        if(ridersMap.containsKey(rider.getId())){
           throw new RuntimeException("Rider already exist");
        }
        ridersMap.put(rider.getId(), rider);
    }

   public Rider getRider(@NonNull final String riderId){
        if(!ridersMap.containsKey(riderId)){
            throw new RuntimeException("Rider doesn't exist");
        }
       return ridersMap.get(riderId);
   }
}
