package com.github.quiram.hackerrank.tests.flippingthematrix;

import java.util.List;
import java.util.stream.IntStream;

class Result {
    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int[][] submatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                submatrix[i][j] = IntStream.of(matrix.get(i).get(j),
                                matrix.get(i).get(2 * n - j - 1),
                                matrix.get(2 * n - i - 1).get(j),
                                matrix.get(2 * n - i - 1).get(2 * n - j - 1)
                        )
                        .max()
                        .orElseThrow();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max += submatrix[i][j];
            }
        }
        return max;
    }

}
