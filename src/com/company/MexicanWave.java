package com.company;

import java.util.ArrayList;
import java.util.List;

public class MexicanWave {

    public static String[] wave(String str) {
        int length = str.length();
        List<String> response = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int charInt = str.charAt(i);
            char upperCaseLetter = (char) (charInt - 32);
            if (charInt < 97 || charInt > 122) {
                continue;
            } else {
                char[] chars = str.toCharArray();
                chars[i] = upperCaseLetter;
                response.add(String.valueOf(chars));
            }
        }
        return response.toArray(new String[response.size()]);
    }
}
/* "      70%\n"+
        "      ██\n"+
        "      ██\n"+
        "      ██\n"+
        "      ██\n"+
        "      ██\n"+
        "      ██\n"+
        "      ██ \n"+
        "      ██ 15%\n"+
        "7%    ██ ██\n"+
        "██ 3% ██ ██    5%\n"+
        "------------------\n"+
        " 1  2  3  4  5  6 " */