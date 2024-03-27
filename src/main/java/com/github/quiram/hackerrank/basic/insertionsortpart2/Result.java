package com.github.quiram.hackerrank.basic.insertionsortpart2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort2/problem">Insertion Sort - Part 2</a>
 */
class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        if (n < 2) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && arr.get(i) < arr.get(j)) {
                j--;
            }
            j++;

            int prev = arr.get(i);

            while (j <= i) {
                int temp = arr.get(j);
                arr.set(j, prev);
                prev = temp;
                j++;
            }

            System.out.printf("%s%n", arr.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }

}
