package com.github.quiram.hackerrank.basic.newyearchaos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four">New Year Chaos</a>
 */
class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> queue) {
        int bribes = 0;
        List<Integer> q = new LinkedList<>(queue);
        boolean bribesFound;
        int[] bribeCount = new int[queue.size()];
        do {
            bribesFound = false;
            for (int i = 1; i < q.size(); i++) {
                if (q.get(i) < q.get(i - 1)) {
                    int temp = q.get(i);
                    q.set(i, q.get(i - 1));
                    q.set(i - 1, temp);
                    bribes++;
                    bribesFound = true;
                    bribeCount[q.get(i) - 1]++;
                }
            }
        }
        while (bribesFound);

        final OptionalInt excessiveBribeCount = Arrays.stream(bribeCount)
                .filter(n -> n > 2)
                .findAny();
        if (excessiveBribeCount.isPresent()) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }

}
