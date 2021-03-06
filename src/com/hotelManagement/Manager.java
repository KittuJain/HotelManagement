package com.hotelManagement;

import java.util.*;

public class Manager {
    private List<Hotel> hotels = new ArrayList<>();

    public void manage(Hotel hotel) {
        hotels.add(hotel);
    }

    public Hotel getCheapestHotel(CustomerCategory category, Sequence days) {
        Integer currentPrice;
        Integer cheapestPrice;
        Hotel cheapestHotel = null;
        Map<Hotel, Integer> costsOfHotels = getCostsOfAllHotels(category, days);
        for (Hotel hotel : costsOfHotels.keySet()) {
            if(cheapestHotel == null) cheapestHotel = hotel;
            currentPrice = costsOfHotels.get(hotel);
            cheapestPrice = costsOfHotels.get(cheapestHotel);
            if(currentPrice < cheapestPrice || currentPrice.equals(cheapestPrice) && hotel.isRatingHigherThan(cheapestHotel))
                cheapestHotel = hotel;
        }
        return cheapestHotel;
    }

    private Map<Hotel, Integer> getCostsOfAllHotels(CustomerCategory category, Sequence days) {
        Map<Hotel, Integer> costs = new HashMap<>();
        for (Hotel hotel : hotels) {
            costs.put(hotel, hotel.getTotalCost(category, days));
        }
        return costs;
    }
}
