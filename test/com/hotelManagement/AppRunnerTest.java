package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppRunnerTest {

    private final AppRunner appRunner = new AppRunner();

    @Before
    public void setUp() throws Exception {
        appRunner.setUp();
    }

    @Test
    public void testRunGetsTheCheapestHotel_01() {
        String[] days = {"Weekday", "Weekday", "Weekday"};
        assertEquals("Cheapest Hotel: Lakewood", appRunner.getCheapestHotel("Regular", days));
    }

    @Test
    public void testRunGetsTheCheapestHotel_02() {
        String[] days = {"Weekday", "Weekend", "Weekend"};
        assertEquals("Cheapest Hotel: Bridgewood", appRunner.getCheapestHotel("Regular", days));
    }

    @Test
    public void testRunGetsTheCheapestHotel_03() {
        String[] days = {"Weekday", "Weekday", "Weekend"};
        assertEquals("Cheapest Hotel: Ridgewood", appRunner.getCheapestHotel("Rewards", days));
    }
}
