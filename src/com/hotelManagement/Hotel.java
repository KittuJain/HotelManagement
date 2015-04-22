package com.hotelManagement;

public class Hotel {
    private String name;
    private int rating;
    private final RateCard rateCard = new RateCard();

    public Hotel(String name, int rating) {

        this.name = name;
        this.rating = rating;
    }

    public boolean addRate(Rate rate) {
        return rateCard.add(rate);
    }

    public int getTotalCost(CustomerCategory category, Sequence days) {
        int cost = 0;
        for (Day day : days) {
            cost += rateCard.getPrice(category, day);
        }
        return cost;
    }

}
