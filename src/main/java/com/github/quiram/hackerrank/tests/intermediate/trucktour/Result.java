package com.github.quiram.hackerrank.tests.intermediate.trucktour;

import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int n = petrolpumps.size();
        int[] d = new int[n]; // deficit in petrol after pump in position i

        IntStream.range(0, n)
                .forEach(i -> d[i] = petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1));

        // Assuming at least one solution so not completing the tour if starting in the middle
        int tank = 0;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            tank += d[i];
            while (tank < 0) {
                tank -= d[candidate];
                candidate++;
            }
        }

        return candidate;
    }

}