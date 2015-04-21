package com.hotelManagement;

import java.util.ArrayList;
import java.util.List;

public class RateCard {

    private final List<Rate> rates = new ArrayList<>();

    public boolean add(Rate rate) {
        if(rates.contains(rate))
            return false;
        rates.add(rate);
        return true;
    }

    public int getPrice(CustomerCategory category, Day day) {
        Rate rate = searchByCategoryAndDay(category, day);
        return rate.getPrice();
    }

    private Rate searchByCategoryAndDay(CustomerCategory customerCategory, Day day) {
        Rate newRate = new Rate(customerCategory, day, 0);
        for (Rate rate : rates) {
            if(rate.equals(newRate))
                return rate;
        }
        return null;
    }
}
