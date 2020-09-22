package com.company;

public class Int32ToIPv6 {
    public static String longToIP(long ip) {
        int address[] = new int[4];
        long remains = ip;
        for (int i = 0; i <= 3; i++) {
            int divider = (int) Math.pow(256, 3-i);
            address[i] = (int) (remains / divider);
            remains = remains % divider;
        }
    return address[0] + "." + address[1] + "." + address[2] + "." + address[3];
    }

}
