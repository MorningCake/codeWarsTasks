package com.company;

import java.util.ArrayList;
import java.util.List;

/* Digital root is the recursive sum of all the digits in a number.
 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2 */
public class DRoot {
    final static int DIVIDER = 10;

    public static int digital_root(int n) {
        while (n > 9) {
            List<Integer> list = new ArrayList<>();
            while (n != 0) {
                list.add(n % DIVIDER);
                n /= DIVIDER;
            }
            for (int i = 0; i <= list.size() - 1; i++) {
                n += list.get(i);
            }
        }
        return n;
    }
}
