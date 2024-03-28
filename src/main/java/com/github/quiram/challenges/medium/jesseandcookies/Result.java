package com.github.quiram.challenges.medium.jesseandcookies;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-jesse-and-cookies/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six">Jesse and Cookies</a>
 */
class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        Integer[] c = A.toArray(new Integer[0]);
        Integer[] m = new Integer[2 * c.length];
        // Write your code here
        int operations = 0;
        Arrays.sort(c);
        int originalIndex = 0;
        int originalEnd = c.length;
        int mergedIndex = 0;
        int mergedEnd = 0;
        while (originalIndex < originalEnd && c[originalIndex] < k || (mergedIndex < mergedEnd && m[mergedIndex] < k)) {
            int[] comb = new int[2];

            for (int i = 0; i < comb.length; i++) {
                if (originalIndex < originalEnd &&
                        (mergedIndex >= mergedEnd || c[originalIndex] < m[mergedIndex])) {
                    // take from c
                    comb[i] = c[originalIndex];
                    originalIndex++;
                } else if (mergedIndex < mergedEnd) {
                    // take from m
                    comb[i] = m[mergedIndex];
                    mergedIndex++;
                } else {
                    return -1;
                }
            }

            int n = comb[0] + 2 * comb[1];
            m[mergedEnd] = n;
            mergedEnd++;
            operations++;
            // if c is consumed, swap it with m, reset indices and carry on
            if (originalIndex == originalEnd && mergedIndex < mergedEnd) {
                c = m;
                originalIndex = mergedIndex;
                originalEnd = mergedEnd;
                m = new Integer[2 * (mergedEnd - mergedIndex)];
                mergedIndex = 0;
                mergedEnd = 0;
            }
        }

        return originalIndex == originalEnd ? -1 : operations;
    }

}