package com.hotelManagement;

import java.util.Arrays;

public class HotelManagement {

    public static void main(String[] args) {
        String inputCategory = args[0];
        String[] inputDays = Arrays.copyOfRange(args, 1, args.length);
        AppRunner appRunner = new AppRunner();
        appRunner.setUp();
        String output = appRunner.run(inputCategory, inputDays);
        System.out.println(output);
    }
}
