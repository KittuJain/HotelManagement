package com.hotelManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence implements Iterable<Day> {
    List<Day> items = new ArrayList<Day>();

    public void add(Day item) {
        items.add(item);
    }

    @Override
    public Iterator<Day> iterator() {
        return items.iterator();
    }
}
