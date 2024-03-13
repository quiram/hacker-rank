package com.github.quiram.hackerrank.intermediate.legoblocks;

import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-lego-blocks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six">Lego Blocks</a>
 */
class Result {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int legoBlocks(int n, int m) {
        // Write your code here
        final int allPermutations = g(n, m);
        final int invalidOnes = IntStream.range(1, m).map(i -> legoBlocks(n, i) * g(n, m - i)).reduce(0, Integer::sum);
        return (allPermutations - invalidOnes) % (1000000007);
    }

    private static int f(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return IntStream.range(0, n)
                .map(Result::f)
                .reduce(0, Integer::sum);
    }

    private static int g(int n, int m) {
        return (int) Math.pow(f(m), n);
    }

}


