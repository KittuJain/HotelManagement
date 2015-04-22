package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    private Hotel lakeWood;
    private Hotel ridgeWood;
    private Hotel bridgeWood;
    private Sequence days;

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

    @Before
    public void setUp() {
        lakeWood = new Hotel("Lakewood", 3);
        bridgeWood = new Hotel("Bridgewood", 4);
        ridgeWood = new Hotel("Ridgewood", 5);
        setUpRates();
        addRatesToHotels();
        days = new Sequence();
    }

    @Test
    public void testGetCheapestHotel_01() {
        Manager manager = new Manager();
        manager.manage(lakeWood);
        manager.manage(bridgeWood);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REGULAR, days);
        assertEquals(lakeWood, hotel);
    }

    @Test
    public void testGetCheapestHotel_02() {
        Manager manager = new Manager();
        manager.manage(lakeWood);
        manager.manage(bridgeWood);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        days.add(Day.WEEKEND);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REGULAR, days);
        assertEquals(bridgeWood, hotel);
    }

    @Test
    public void testGetCheapestHotel_03() {
        Manager manager = new Manager();
        manager.manage(lakeWood);
        manager.manage(bridgeWood);
        manager.manage(ridgeWood);

        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REGULAR, days);
        assertEquals(lakeWood, hotel);
    }

    @Test
    public void testGetCheapestHotel_04() {
        Manager manager = new Manager();
        manager.manage(lakeWood);
        manager.manage(bridgeWood);
        manager.manage(ridgeWood);

        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REWARDS, days);
        assertEquals(ridgeWood, hotel);
    }
}
