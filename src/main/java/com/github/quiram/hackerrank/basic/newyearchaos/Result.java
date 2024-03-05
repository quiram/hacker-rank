package com.github.quiram.hackerrank.basic.newyearchaos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> q = new LinkedList<>(queue);
        boolean bribesFound;
        boolean tooChaotic = false;
        int[] bribeCount = new int[queue.size()];
        do {
            bribesFound = false;
            for (int i = 1; i < q.size() && !tooChaotic; i++) {
                if (q.get(i) < q.get(i - 1)) {
                    int temp = q.get(i);
                    q.set(i, q.get(i - 1));
                    q.set(i - 1, temp);
                    bribesFound = true;
                    bribeCount[q.get(i) - 1]++;
                    if (bribeCount[q.get(i) - 1] > 2) {
                        tooChaotic = true;
                    }
                }
            }
        }
        while (bribesFound && !tooChaotic);

        if (tooChaotic) {
            System.out.println("Too chaotic");
        } else {
            final int bribes = Arrays.stream(bribeCount).reduce(0, Integer::sum);
            System.out.println(bribes);
        }
    }
}
