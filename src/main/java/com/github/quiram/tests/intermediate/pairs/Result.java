package com.github.quiram.tests.intermediate.pairs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        int pairs = 0;

        Set<Integer> numbers = new HashSet<>(arr);

        for (int n : arr) {
            if (numbers.contains(n + k)) {
                pairs++;
            }
        }

        return pairs;
    }

}