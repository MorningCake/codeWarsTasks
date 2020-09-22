package com.company;

import java.util.ArrayList;
import java.util.List;

public class NextBiggerInt {
    private static List<String> permissions;

    public static long nextBiggerNumber(long n)
    {
        permissions = new ArrayList<>();
        String numString = String.valueOf(n);
        int length = numString.length();
        if (length < 2) {
            return -1;
        } else {
            permutationWithPrefix("", numString);

            return permissions.stream()
                    .map(s -> Long.valueOf(s))
                    .sorted()
                    .filter(i -> i > n).findFirst().orElse((long) -1);
        }
    }

    public static void permutationWithPrefix(String prefix, String str) {
        int n = str.length();
        if (n == 0) permissions.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutationWithPrefix(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
