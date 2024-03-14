package com.github.quiram.hackerrank.intermediate.legoblocks;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-lego-blocks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six">Lego Blocks</a>
 */
class Result {

    private final static Map<String, Integer> intCache = new ConcurrentHashMap<>();
    private final static Map<String, BigInteger> bigIntegerCache = new ConcurrentHashMap<>();

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
        final String key = String.format("h(%s,%s)", n, m);
        final Integer maybeResult = intCache.get(key);
        if (maybeResult != null) {
            return maybeResult;
        }

        final BigInteger allPermutations = g(n, m);
        final BigInteger invalidOnes = IntStream.range(1, m)
                .parallel()
                .mapToObj(i -> g(n, m - i).multiply(BigInteger.valueOf(legoBlocks(n, i))))
                .reduce(ZERO, BigInteger::add);
        final int result = allPermutations.subtract(invalidOnes)
                .remainder(BigInteger.valueOf(1000000007))
                .intValueExact();
        intCache.put(key, result);
        return result;
    }

    private static BigInteger f(int n) {
        if (n < 0) {
            return ZERO;
        }

        if (n == 0) {
            return ONE;
        }

        final String key = String.format("f(%s)", n);
        final BigInteger maybeResult = bigIntegerCache.get(key);
        if (maybeResult != null) {
            return maybeResult;
        }

        final BigInteger result = IntStream.range(1, 5)
                .mapToObj(i -> f(n - i))
                .reduce(ZERO, BigInteger::add);
        bigIntegerCache.put(key, result);
        return result;
    }

    private static BigInteger g(int n, int m) {
        final String key = String.format("g(%s,%s)", n, m);
        final BigInteger maybeResult = bigIntegerCache.get(key);
        if (maybeResult != null) {
            return maybeResult;
        }

        final BigInteger result = f(m).pow(n);
        bigIntegerCache.put(key, result);
        return result;
    }

}


