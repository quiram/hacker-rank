package com.github.quiram.hackerrank.basic.icecreamparlor;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://www.hackerrank.com/challenges/icecream-parlor/problem">Ice Cream Parlor</a>
 */
class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> costs = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            costs.put(arr.get(i), i);
        }

        for (int i = 0; i < arr.size(); i++) {
            Integer otherIndex = costs.get(m - arr.get(i));
            if (otherIndex != null && i != otherIndex) {
                return List.of(i + 1, otherIndex + 1);
            }
        }

        throw new RuntimeException("no solution");
    }

}