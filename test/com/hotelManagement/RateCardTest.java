package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateCardTest {

    private RateCard rateCard;
    private CustomerCategory regular;
    private Day weekday;
    private CustomerCategory rewards;
    private Day weekend;

    @Before
    public void setUp() throws Exception {
        rateCard = new RateCard();
        regular = CustomerCategory.REGULAR;
        weekday = Day.WEEKDAY;
        rewards = CustomerCategory.REWARDS;
        weekend = Day.WEEKEND;
    }

    @Test
    public void testAddReturnsTrueIfRateIsAddedToTheRateCard() {
        Rate rate = new Rate(regular, weekday, 110);
        assertTrue(rateCard.add(rate));
    }

    @Test
    public void testAddReturnsFalseIfSameRateIsAddedTwiceToTheRateCard() {
        Rate rate1 = new Rate(regular, weekday, 110);
        Rate rate2 = new Rate(regular, weekday, 110);
        assertTrue(rateCard.add(rate1));
        assertFalse(rateCard.add(rate2));
    }

    @Test
    public void testAddReturnsFalseIfSameRateWithDifferentPriceIsAddedTwiceToTheRateCard() {
        Rate rate1 = new Rate(regular, weekday, 110);
        Rate rate2 = new Rate(regular, weekday, 20);
        assertTrue(rateCard.add(rate1));
        assertFalse(rateCard.add(rate2));
    }

    @Test
    public void testGetPriceGetsThePriceOfWeekdayForRegularCustomer () {
        Rate rate = new Rate(regular, weekday, 110);
        rateCard.add(rate);
        int price = rateCard.getPrice(regular, weekday);
        assertEquals(110, price);
    }

    @Test
    public void testGetPriceGetsThePriceOfWeekendForRewardCustomer () {
        Rate rate = new Rate(rewards, weekend, 80);
        rateCard.add(rate);
        int price = rateCard.getPrice(rewards, weekend);
        assertEquals(80, price);
    }
}