package com.company;

/**
 *  i - index of ranges [1...9], [10...99] ...
 *  j - current number from i range
 * M, N - min and max Indexes for i range [1...9], [10...99] ...
 * A, B - min and max Indexes for current number j
 */
public class ArithmeticProgression {

    private static long M, N, Nmemory, avg, max, maxMemory, index = 0L;
    private static int answer;

    public static int solve(long num){
        for (int i = 1;;i++) {
            M = ArithmeticProgression.calcM(i);
            N = ArithmeticProgression.calcN(i);

            if(i == 1) {
                max = ArithmeticProgression.sumFromOneTo((int) N);
            } else {
                maxMemory = max;
                max = ArithmeticProgression.calcB(i, N);
            }
            // search with loop
            if (num <= max) {
                long A = 0L;
                long B = 0L;
                while (N > M) {
                    //divide the range and step left
                    Nmemory = N;
                    avg = (M + N)/2;
                    N = avg;
                    A = ArithmeticProgression.calcA(i, N);
                    B = ArithmeticProgression.calcB(i, N);
                    if (num > B) {
                        //step right
                        M = N + 1;
                        N = Nmemory;
                        A = ArithmeticProgression.calcA(i, N);
                    }
                }
                //calc a number and index
                index = num - A + 1;
                for (int j = 1; j < i; j++) {
                    index -= 9 * j * Math.pow(10, j-1);
                }
                int mod = (int) index % i;
                int div = (int) index / i;
                int number;
                if (mod == 0) {
                    number = (int) ArithmeticProgression.calcM(i) + div - 1;
                    index = i - 1;
                } else {
                    number = (int) ArithmeticProgression.calcM(i) + div;
                    index = mod - 1;
                }
                return (int) (number / Math.pow(10, i - index -1)) % 10;
            }
        }
    }

    private static long sumFromOneTo(long k) {
        return (2+(k-1))*k/2;
    }
    private static long calcM(int i) {
        return (long) Math.pow(10, i-1);
    }
    private static long calcN(int i) {
        return (long) Math.pow(10, i) - 1;
    }
    private static long calcB(int i, long j) {
        if (i == 1) {
            return ArithmeticProgression.sumFromOneTo((int) j);
        } else {
            long M = ArithmeticProgression.calcM(i);
            long k = j - M + 1;
            return maxMemory +  k * ArithmeticProgression.calcMul(i) + i * ArithmeticProgression.sumFromOneTo(k);
        }
    }
    private static long calcMul(int i) {
        long mul = 0L;
        for (int l = 1; l < i; l++) {
            mul += l * (Math.pow(10, l) - Math.pow(10, l-1));
        }
        return mul;
    }
    private static long calcA(int i, long j) {
        if (i == 1) {
            return ArithmeticProgression.sumFromOneTo((int) j-1) + 1L;
        } else {
            return ArithmeticProgression.calcB(i, j-1) + 1L;
        }
    }
}
