package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    private Hotel lakeWood;
    private Rate wdRegularRate;
    private Rate weRegularRate;
    private Hotel bridgeWood;
    private Sequence days;

    private void log(String testMessage) {
        System.out.println(testMessage);
    }

    @Before
    public void setUp(){
        lakeWood = new Hotel("Lakewood", 3);
        bridgeWood = new Hotel("Bridgewood", 4);
        wdRegularRate = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        weRegularRate = new Rate(CustomerCategory.REGULAR, Day.WEEKEND, 90);
        lakeWood.addRate(wdRegularRate);
        lakeWood.addRate(weRegularRate);
        days = new Sequence();
    }

    @Test
    public void testGetTotalCost1 () {
        log("Returns total cost for 2 weekdays and a weekend accommodation in lakewood for regular customer");
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKEND);
        int totalCost = lakeWood.getTotalCost(CustomerCategory.REGULAR, days);
        assertEquals(310, totalCost);
    }

    @Test
    public void testGetTotalCost2 () {
        log("Returns total cost for 2 weekdays and a weekend accommodation in bridgeWood for reward customer");
        bridgeWood.addRate(new Rate(CustomerCategory.REWARDS, Day.WEEKDAY, 110));
        bridgeWood.addRate(new Rate(CustomerCategory.REWARDS, Day.WEEKEND, 50));
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        days.add(Day.WEEKDAY);
        int totalCost = bridgeWood.getTotalCost(CustomerCategory.REWARDS, days);
        assertEquals(330, totalCost);
    }
}
