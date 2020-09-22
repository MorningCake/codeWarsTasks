package com.company;

public class Maskify {
    public static String maskify(String str) {
        //throw new UnsupportedOperationException("Unimplemented");
        int strLength = str.length();
        final int SHOWN_LENGTH = 4;

        if (strLength <= SHOWN_LENGTH) {
            return str;
        } else {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = strLength; i > SHOWN_LENGTH; i-- ) {
                strBuilder.append("#");
            }
            for (int i = strLength - SHOWN_LENGTH; i <= strLength - 1; i++ ) {
                strBuilder.append(str.charAt(i));
            }
            return strBuilder.toString();
        }
    }
}
