package com.hotelManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence implements Iterable<Day> {
    List<Day> days = new ArrayList<>();

    public void add(Day item) {
        days.add(item);
    }

    @Override
    public Iterator<Day> iterator() {
        return days.iterator();
    }
}
