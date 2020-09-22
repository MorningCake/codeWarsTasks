package com.company;

//IPv4 address
public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        String[] startStrings = getDividedStrings(start);
        String[] endStrings = getDividedStrings(end);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (Integer.valueOf(endStrings[i]) - Integer.valueOf(startStrings[i])) * Math.pow(256, 3-i);
        }
        return sum;
    }

    public static String[] getDividedStrings(String str) {
        String[] dividedStrings = new String[4];
        for (int i = 0; i < 4; i++) {
            dividedStrings = str.split("\\.", 4);
        }
        return dividedStrings;
    }
}
