package com.hotelManagement;

public class AppRunner {

    private Hotel lakeWood;
    private CustomerCategory regular;
    private CustomerCategory rewards;
    private Day weekend;
    private Day weekday;

    public void setUp() {
        lakeWood = new Hotel("LakeWood", 3);
        regular = CustomerCategory.REGULAR;
        rewards = CustomerCategory.REWARDS;
        weekend = Day.WEEKEND;
        weekday = Day.WEEKDAY;

        lakeWood.addRate(new Rate(regular, weekday, 110));
        lakeWood.addRate(new Rate(regular, weekend, 80));
        lakeWood.addRate(new Rate(rewards, weekday, 90));
        lakeWood.addRate(new Rate(rewards, weekend, 80));

    }

    public String run(String inputCategory, String[] inputDays) {
        Sequence days = convertToSequence(inputDays);
        CustomerCategory category = getCategory(inputCategory);
        setUp();
        return "Total Cost = " + lakeWood.getTotalCost(category, days);
    }

    private CustomerCategory getCategory(String inputCategory) {
        inputCategory = inputCategory.toLowerCase();

        if (inputCategory.equals("regular")) return CustomerCategory.REGULAR;
        return CustomerCategory.REWARDS;
    }

    private Sequence convertToSequence(String[] inputDays) {
        Sequence days = new Sequence();
        for (String inputDay : inputDays) {
            inputDay = inputDay.toLowerCase();
            if (inputDay.equals("weekday")) days.add(Day.WEEKDAY);
            if (inputDay.equals("weekend")) days.add(Day.WEEKEND);
        }
        return days;
    }
}