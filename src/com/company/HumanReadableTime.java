package com.company;

public class HumanReadableTime {
    private final static int SECONDS_PER_HOUR = 3600;
    private final static int SECONDS_PER_MINUTE = 60;
    public static String makeReadable(int seconds) {
        int hours = seconds / SECONDS_PER_HOUR;
        int remainder = seconds - hours * SECONDS_PER_HOUR;
        int minutes = remainder / SECONDS_PER_MINUTE;
        remainder -= minutes * SECONDS_PER_MINUTE;
        StringBuilder time = new StringBuilder();
        if (hours < 10) {
            time.append("0" + hours + ":");
        } else {
            time.append(hours + ":");
        }
        if (minutes < 10) {
            time.append("0" + minutes + ":");
        } else {
            time.append(minutes + ":");
        }
        if (remainder < 10) {
            time.append("0" + remainder);
        } else {
            time.append(remainder);
        }
        return time.toString();
    }
}
