package com.hotelManagement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateCardTest {

    private RateCard rateCard;

    @Before
    public void setUp() throws Exception {
        rateCard = new RateCard();
    }

    @Test
    public void testAddReturnsTrueIfRateIsAddedToTheRateCard() {
        Rate rate = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        assertTrue(rateCard.add(rate));
    }

    @Test
    public void testAddReturnsFalseIfSameRateIsAddedTwiceToTheRateCard() {
        Rate rate1 = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        Rate rate2 = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        assertTrue(rateCard.add(rate1));
        assertFalse(rateCard.add(rate2));
    }

    @Test
    public void testAddReturnsFalseIfSameRateWithDifferentPriceIsAddedTwiceToTheRateCard() {
        Rate rate1 = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        Rate rate2 = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 20);
        assertTrue(rateCard.add(rate1));
        assertFalse(rateCard.add(rate2));
    }

    @Test
    public void testGetPriceGetsThePriceOfWeekdayOfRegularCustomer () {
        Rate rate = new Rate(CustomerCategory.REGULAR, Day.WEEKDAY, 110);
        rateCard.add(rate);
        int price = rateCard.getPrice(CustomerCategory.REGULAR, Day.WEEKDAY);
        assertEquals(110, price);
    }
}