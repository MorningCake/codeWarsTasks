package com.company;

import java.util.Arrays;

public class HistogramV2 {

    private static final String BAR = "██ ";
    private static final String TRIPLE_HYPHEN = "---";
    private static final String TRIPLE_SPACE = "   ";

    public static String histogram(final int results[]) {
        // 1 - calculations
        int sum = Arrays.stream(results).sum();
        double[] percents = Arrays.stream(results).mapToDouble(n -> (double) n).map( n -> 100*n/sum ).toArray();
        int length = results.length;
        String[] percentStr = new String[length];
        int barQnt[] = new int[length];
        int maxBarQnt = 0;

        for (int i = 0; i < length; i++) {
            if (percents[i] == 0 || sum == 0) {
                percentStr[i] = TRIPLE_SPACE;
                barQnt[i] = 0;
            }
            else if (percents[i] < 1) {
                percentStr[i] = "<1%";
                barQnt[i] = 0;
            }
            else {
                if (((int) percents[i]) < 10) {
                    percentStr[i] = ((int) percents[i]) + "% ";
                } else {
                    percentStr[i] = ((int) percents[i]) + "%";
                }
                barQnt[i] = (int) (percents[i] / 100 * 15);
            }
            if (barQnt[i] > maxBarQnt) {
                maxBarQnt = barQnt[i];
            }
        }
        int matrixRowsQnt = 3 + maxBarQnt;

        // 2 - create info blocks - string matrix
        String[][] matrix = new String[length][matrixRowsQnt];

        for (int i = 0; i < length;  i++) {
            for (int j = 0; j < matrixRowsQnt ; j++) {
                if (j == 0) {
                    if (i < 10) {
                        if (i == length - 1) {
                            matrix[i][j] = " " + (i+1);
                        } else {
                            matrix[i][j] = " " + (i+1) + " ";
                        }
                    } else if (i < 100){
                        matrix[i][j] = " " + (i+1); /// может быть пробел справа!
                    } else {
                        matrix[i][j] = "" + (i+1);
                    }
                    continue;
                }
                if (j == 1) {
                    matrix[i][j] = TRIPLE_HYPHEN;
                    continue;
                }
                if (j == 2 && barQnt[i] > 0) {
                    for (int k = 2; k < barQnt[i] + 2; k++) {
                        matrix[i][k] = BAR;
                    }
                    j += barQnt[i] - 1;
                    continue;
                }
                if (j == barQnt[i] + 2) {
                    matrix[i][j] = percentStr[i];
                    continue;
                }
                //пробелы до конца
                if (j == barQnt[i] + 3 && j < matrixRowsQnt) {
                    for (int k = barQnt[i] + 3; k < matrixRowsQnt; k++, j++) {
                        matrix[i][k] = TRIPLE_SPACE;
                    }
                    continue;
                }
            }
        }
        // 3 - transpose a matrix
        String[][] transposedMatrix = new String[matrixRowsQnt][length];
        for (int i = 0; i < length;  i++) {
            for (int j = 0; j < matrixRowsQnt ; j++) {
                transposedMatrix[matrixRowsQnt-1 - j][i] = matrix[i][j];
            }
        }
        // 4 - output
        StringBuilder mainBuilder = new StringBuilder();
        for (int i = 0; i < matrixRowsQnt;  i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < length; j++) {
                rowBuilder.append(transposedMatrix[i][j]);
            }
            if (i < matrixRowsQnt - 2) {
                String rowStr = rowBuilder.toString();
                int percentLastIndex = rowStr.lastIndexOf('%');
                int barLastIndex = rowStr.lastIndexOf('█');
                int maxIndex = (percentLastIndex > barLastIndex) ? percentLastIndex : barLastIndex;
                if (maxIndex == -1) {
                    continue;
                } else {
                    mainBuilder.append(rowStr.substring(0, maxIndex + 1) + "\n");
                }
            }
            else {
                mainBuilder.append(rowBuilder.toString() + "\n");
            }
        }
        return mainBuilder.toString();
    }
}
