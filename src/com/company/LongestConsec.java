package com.company;

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        // 1 - get an array with words length
        int starrLength = strarr.length;
        if (starrLength == 0 || k > starrLength || k <= 0) {
            return "";
        } else {
            int wordsLength[] = new int[starrLength];
            for (int i = 0; i < starrLength; i++) {
                wordsLength[i] = strarr[i].length();
            }
            // 2 - found a sequence with max length
            int max = 0;
            int index = 0;
            int sum;
            for (int i = 0; i <= starrLength - k; i++) {
                sum = 0;
                for (int j = i; j < i + k; j++) {
                    sum += wordsLength[j];
                }
                if (sum > max) {
                    max = sum;
                    index = i;
                }
            }
            // 3 - get a result
            StringBuilder builder = new StringBuilder();
            for (int i = index; i < index + k; i++) {
                builder.append(strarr[i]);
            }
            return builder.toString();
        }
    }
}
