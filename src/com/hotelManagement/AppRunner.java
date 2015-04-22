package com.hotelManagement;

public class AppRunner {
    //setup start
    private final Manager manager = new Manager();
    private Hotel lakewood;
    private Hotel ridgewood;
    private Hotel bridgewood;

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
        lakewood.addRate(wdRegularRateLakewood);
        lakewood.addRate(weRegularRateLakewood);
        lakewood.addRate(wdRewardRateLakewood);
        lakewood.addRate(weRewardRateLakewood);

        bridgewood.addRate(wdRegularRateBridgewood);
        bridgewood.addRate(weRegularRateBridgewood);
        bridgewood.addRate(wdRewardRateBridgewood);
        bridgewood.addRate(weRewardRateBridgewood);

        ridgewood.addRate(wdRegularRateRidgewood);
        ridgewood.addRate(weRegularRateRidgewood);
        ridgewood.addRate(wdRewardRateRidgewood);
        ridgewood.addRate(weRewardRateRidgewood);
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
        lakewood = new Hotel("Lakewood", 3);
        bridgewood = new Hotel("Bridgewood", 4);
        ridgewood = new Hotel("Ridgewood", 5);
        manager.manage(lakewood);
        manager.manage(bridgewood);
        manager.manage(ridgewood);
        setUpRates();
        addRatesToHotels();
    }

    //setup end

    public String getCheapestHotel(String inputCategory, String[] inputDays) {
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
