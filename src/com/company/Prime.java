package com.company;

public class Prime {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        else if ((num > 2 && num % 2 == 0) || (num > 5 && num % 5 == 0)) return false;
        else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
