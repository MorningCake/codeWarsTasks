package com.company;

public class StringValue {
    public static String high(String s) {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
                'x','y','z'};
        int last = s.lastIndexOf(" ");
        int end;
        int begin = 0;
        int maxWordValue = 0;
        StringBuilder maxString = new StringBuilder("");
        do {
            if (begin < last) {
                end = s.indexOf(" ", begin);
            } else {
                end = s.length();
            }
            String substring = s.substring(begin, end);
            int currentWordValue = 0;
            for (int i = 0; i < substring.length(); i++) {
                char letter = substring.charAt(i);
                for (int j = 0; j <= 25; j++) {
                    if (substring.charAt(i) == alphabet[j]) {
                        currentWordValue += j + 1;
                        break;
                    }
                }
            }
            if (currentWordValue > maxWordValue) {
                maxWordValue = currentWordValue;
                maxString = new StringBuilder(substring);
            }
            begin = end + 1;
        } while (end <= last);

        return maxString.toString();
    }
}
