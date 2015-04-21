package com.hotelManagement;

public class Rate {
    private final CustomerCategory category;
    private final Day day;
    private int price;

    public Rate(CustomerCategory category, Day day, int price) {
        this.category = category;
        this.day = day;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;
        if (category != rate.category) return false;
        return day == rate.day;

    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + day.hashCode();
        result = 31 * result + price;
        return result;
    }

    public int getPrice() {
        return price;
    }
}
