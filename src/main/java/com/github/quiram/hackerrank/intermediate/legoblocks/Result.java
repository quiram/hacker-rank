package com.github.quiram.hackerrank.intermediate.legoblocks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-lego-blocks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six">Lego Blocks</a>
 */
class Result {

    private final static Map<String, Integer> intCache = new ConcurrentHashMap<>();
    private final static Map<String, Long> longCache = new ConcurrentHashMap<>();
    private static final int base = 1000000007;

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

        final long allPermutations = g(n, m);
        final long invalidOnes = IntStream.range(1, m)
                .parallel()
                .mapToLong(i -> ((g(n, m - i) * (legoBlocks(n, i))) % base))
                .reduce(0, (a, b) -> (a + b) % base);
        final int result = (int) ((allPermutations - invalidOnes + base) % base);
        intCache.put(key, result);
        return result;
    }

    private static long f(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        final String key = String.format("f(%s)", n);
        final Long maybeResult = longCache.get(key);
        if (maybeResult != null) {
            return maybeResult;
        }

        final long result = IntStream.range(1, 5)
                .mapToObj(i -> f(n - i))
                .reduce(0L, (a, b) -> (a + b) % base);
        longCache.put(key, result);
        return result;
    }

    private static long g(int n, int m) {
        final String key = String.format("g(%s,%s)", n, m);
        final Long maybeResult = longCache.get(key);
        if (maybeResult != null) {
            return maybeResult;
        }

        final long result = IntStream.range(0, n)
                .mapToLong($ -> f(m))
                .reduce(1, (a, b) -> (a * b) % base);
        longCache.put(key, result);
        return result;
    }

}


