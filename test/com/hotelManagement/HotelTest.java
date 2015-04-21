package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    private Hotel lakeWood;
    private Rate wdRegRate;
    private Rate weRegRate;
    private Hotel bridgeWood;

    @Before
    public void setUp() throws Exception {
        lakeWood = new Hotel("Lakewood", 3);
        bridgeWood = new Hotel("Bridgewood", 3);
        wdRegRate = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        weRegRate = new Rate(CustomerCategory.REGULAR, Day.WEEKEND, 80);
        lakeWood.addRate(wdRegRate);
        lakeWood.addRate(weRegRate);
    }

    @Test
    public void testGetTotalCostReturnsTotalCostFor2WeekDaysAndAWeekEndAccommodationInLakewood () {
        Sequence days = new Sequence();
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        int totalCost = lakeWood.getTotalCost(CustomerCategory.REGULAR, days);
        assertEquals(300, totalCost);
    }

    @Test
    public void testGetTotalCostReturnsTotalCostOfTheAccommodation() {
        bridgeWood.addRate(new Rate(CustomerCategory.REWARDS, Day.WEEKDAY, 110));
        bridgeWood.addRate(new Rate(CustomerCategory.REWARDS, Day.WEEKEND, 50));
        Sequence days = new Sequence();
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        int totalCost = bridgeWood.getTotalCost(CustomerCategory.REWARDS, days);
        assertEquals(330, totalCost);
    }
}
