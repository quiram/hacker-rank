package com.github.quiram.hackerrank.intermediate.legoblocks;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

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
        final BigDecimal allPermutations = g(n, m);
        final BigDecimal invalidOnes = IntStream.range(1, m)
                .mapToObj(i -> g(n, m - i).multiply(new BigDecimal(legoBlocks(n, i))))
                .reduce(ZERO, BigDecimal::add);
        return allPermutations.subtract(invalidOnes)
                .remainder(new BigDecimal(1000000007))
                .intValueExact();
    }

    private static BigDecimal f(int n) {
        if (n < 0) {
            return ZERO;
        }

        if (n == 0) {
            return ONE;
        }

        return IntStream.range(1, 5)
                .mapToObj(i -> f(n - i))
                .reduce(new BigDecimal(0), BigDecimal::add);
    }

    private static BigDecimal g(int n, int m) {
        return f(m).pow(n);
    }

}


