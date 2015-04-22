package com.hotelManagement;

public class AppRunner {
    //setup start
    private final Manager manager = new Manager();
    private Hotel lakeWood;
    private Hotel ridgeWood;
    private Hotel bridgeWood;

    private Rate wdRegularRateLakewood;
    private Rate weRegularRateLakewood;
    private Rate wdRewardRateLakewood;
    private Rate weRewardRateLakewood;

    private Rate weRewardRateBridgewood;
    private Rate wdRegularRateBridgewood;
    private Rate weRegularRateBridgewood;
    private Rate wdRewardRateBridgewood;

    private Rate weRewardRateRidgewood;
    private Rate wdRegularRateRidgewood;
    private Rate weRegularRateRidgewood;
    private Rate wdRewardRateRidgewood;

    private void addRatesToHotels() {
        lakeWood.addRate(wdRegularRateLakewood);
        lakeWood.addRate(weRegularRateLakewood);
        lakeWood.addRate(wdRewardRateLakewood);
        lakeWood.addRate(weRewardRateLakewood);

        bridgeWood.addRate(wdRegularRateBridgewood);
        bridgeWood.addRate(weRegularRateBridgewood);
        bridgeWood.addRate(wdRewardRateBridgewood);
        bridgeWood.addRate(weRewardRateBridgewood);

        ridgeWood.addRate(wdRegularRateRidgewood);
        ridgeWood.addRate(weRegularRateRidgewood);
        ridgeWood.addRate(wdRewardRateRidgewood);
        ridgeWood.addRate(weRewardRateRidgewood);
    }

    private void setUpRates() {
        wdRegularRateLakewood = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        weRegularRateLakewood = new Rate(CustomerCategory.REGULAR, Day.WEEKEND, 90);
        wdRewardRateLakewood = new Rate(CustomerCategory.REWARDS, Day.WEEKDAY, 80);
        weRewardRateLakewood = new Rate(CustomerCategory.REWARDS, Day.WEEKEND, 80);

        wdRegularRateBridgewood = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 160);
        weRegularRateBridgewood = new Rate(CustomerCategory.REGULAR, Day.WEEKEND, 60);
        wdRewardRateBridgewood = new Rate(CustomerCategory.REWARDS, Day.WEEKDAY, 110);
        weRewardRateBridgewood = new Rate(CustomerCategory.REWARDS, Day.WEEKEND, 50);

        wdRegularRateRidgewood = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 220);
        weRegularRateRidgewood = new Rate(CustomerCategory.REGULAR, Day.WEEKEND, 150);
        wdRewardRateRidgewood = new Rate(CustomerCategory.REWARDS, Day.WEEKDAY, 100);
        weRewardRateRidgewood = new Rate(CustomerCategory.REWARDS, Day.WEEKEND, 40);
    }

    public void setUp() {
        lakeWood = new Hotel("Lakewood", 3);
        bridgeWood = new Hotel("Bridgewood", 4);
        ridgeWood = new Hotel("Ridgewood", 5);
        manager.manage(lakeWood);
        manager.manage(bridgeWood);
        manager.manage(ridgeWood);
        setUpRates();
        addRatesToHotels();
    }

    //setup end

    public String run(String inputCategory, String[] inputDays) {
        Sequence days = convertToSequence(inputDays);
        CustomerCategory category = getCategory(inputCategory);
        return "Cheapest Hotel: " + manager.getCheapestHotel(category,days);
    }

    private CustomerCategory getCategory(String inputCategory) {
        inputCategory = inputCategory.toLowerCase();
        if (inputCategory.equals("regular")) return CustomerCategory.REGULAR;
        return CustomerCategory.REWARDS;
    }

    private Sequence convertToSequence(String[] inputDays) {
        Sequence days = new Sequence();
        for (String inputDay : inputDays) days.add(getDay(inputDay));
        return days;
    }

    private Day getDay(String inputDay) {
        inputDay = inputDay.toLowerCase();
        if (inputDay.equals("weekday")) return Day.WEEKDAY;
        return Day.WEEKEND;
    }
}
