package com.company;

import java.math.BigInteger;

public class Padovan {
    private static final int NUMS_PER_ROW = 5;

    public static BigInteger Get (long power)
    {
        int searchRow = (int) power / NUMS_PER_ROW;
        int searchColumn = (int) power % NUMS_PER_ROW;

        BigInteger[][] matrix = new BigInteger[searchRow + 1][NUMS_PER_ROW];
        matrix[0][0] = BigInteger.ONE;
        matrix[0][1] = BigInteger.ONE;
        matrix[0][2] = BigInteger.ONE;
        matrix[0][3] = BigInteger.valueOf(2);
        matrix[0][4] = BigInteger.valueOf(2);
        
        if (searchRow < 1) {
            return matrix[0][searchColumn];
        } else {
            for (int i = 1; i <= searchRow; i++) {
                for (int j = 0; j < NUMS_PER_ROW; j++) {
                    if (j == 0) {
                        matrix[i][j] = matrix[i-1][j].add(matrix[i-1][NUMS_PER_ROW -1]);
                    } else {
                        matrix[i][j] = matrix[i][j-1].add(matrix[i-1][j]);
                    }
                    if (i == searchRow && j == searchColumn) {
                        break;
                    }
                }
                if (i > 10){
                    for (int k = 0; k < NUMS_PER_ROW; k++) {
                        matrix[i-2][k] = matrix[i-1][k];
                        matrix[i-1][k] = matrix[i][k];
                    }
                    i--;
                    searchRow--;
                }
            }
            return matrix[searchRow][searchColumn];
        }
    }
}
