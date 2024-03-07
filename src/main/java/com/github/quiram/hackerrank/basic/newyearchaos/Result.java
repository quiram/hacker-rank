package com.github.quiram.hackerrank.basic.newyearchaos;

import java.util.ArrayList;
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
        List<Integer> q = new ArrayList<>(queue);

        int bribes = 0;
        boolean chaos = false;
        for (int i = q.size() - 1; i >= 0; i--) {
            int expectedTicket = i + 1;
            if (i - 1 >= 0 && q.get(i - 1) == expectedTicket) {
                bribes++;
                int tmp = q.get(i);
                q.set(i, q.get(i - 1));
                q.set(i - 1, tmp);
            } else if (i - 2 >= 0 && q.get(i - 2) == expectedTicket) {
                bribes += 2;

                int tmp = q.get(i - 2);
                q.set(i - 2, q.get(i - 1));
                q.set(i - 1, q.get(i));
                q.set(i, tmp);
            } else if (q.get(i) != expectedTicket) {
                chaos = true;
                break;
            }
        }

        System.out.println(chaos ? "Too chaotic" : bribes);
    }
}
