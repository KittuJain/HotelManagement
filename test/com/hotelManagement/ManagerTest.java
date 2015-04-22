package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    private Hotel lakewood;
    private Hotel ridgewood;
    private Hotel bridgewood;
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

    @Before
    public void setUp() {
        lakewood = new Hotel("Lakewood", 3);
        bridgewood = new Hotel("Bridgewood", 4);
        ridgewood = new Hotel("Ridgewood", 5);
        setUpRates();
        addRatesToHotels();
        days = new Sequence();
    }

    @Test
    public void testGetCheapestHotel_01() {
        Manager manager = new Manager();
        manager.manage(lakewood);
        manager.manage(bridgewood);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REGULAR, days);
        assertEquals(lakewood, hotel);
    }

    @Test
    public void testGetCheapestHotel_02() {
        Manager manager = new Manager();
        manager.manage(lakewood);
        manager.manage(bridgewood);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        days.add(Day.WEEKEND);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REGULAR, days);
        assertEquals(bridgewood, hotel);
    }

    @Test
    public void testGetCheapestHotel_03() {
        Manager manager = new Manager();
        manager.manage(lakewood);
        manager.manage(bridgewood);
        manager.manage(ridgewood);

        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REGULAR, days);
        assertEquals(lakewood, hotel);
    }

    @Test
    public void testGetCheapestHotel_04() {
        Manager manager = new Manager();
        manager.manage(lakewood);
        manager.manage(bridgewood);
        manager.manage(ridgewood);

        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        Hotel hotel = manager.getCheapestHotel(CustomerCategory.REWARDS, days);
        assertEquals(ridgewood, hotel);
    }
}
