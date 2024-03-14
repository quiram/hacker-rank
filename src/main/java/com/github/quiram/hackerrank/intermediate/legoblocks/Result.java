package com.github.quiram.hackerrank.intermediate.legoblocks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-lego-blocks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six">Lego Blocks</a>
 */
class Result {

    private final static Map<Integer, Long> hCache = new ConcurrentHashMap<>();
    private final static Map<Integer, Long> fCache = new ConcurrentHashMap<>();
    private final static Map<Integer, Long> gCache = new ConcurrentHashMap<>();
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
        resetCaches();
        return h(n, m);
    }

    private static int h(int n, int m) {
        // Write your code here
        final Long maybeResult = hCache.get(m);
        if (maybeResult != null) {
            return (int) maybeResult.longValue();
        }

        final long allPermutations = g(n, m);
        final long invalidOnes = IntStream.range(1, m)
                .mapToLong(i -> ((g(n, m - i) * (h(n, i))) % base))
                .reduce(0, (a, b) -> (a + b) % base);
        final long result = (allPermutations - invalidOnes + base) % base;
        hCache.put(m, result);
        return (int) result;
    }

    private static long f(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        final Long maybeResult = fCache.get(n);
        if (maybeResult != null) {
            return maybeResult;
        }

        final long result = IntStream.range(1, 5)
                .mapToObj(i -> f(n - i))
                .reduce(0L, (a, b) -> (a + b) % base);
        fCache.put(n, result);
        return result;
    }

    private static long g(int n, int m) {
        final Long maybeResult = gCache.get(m);
        if (maybeResult != null) {
            return maybeResult;
        }

        final long result = IntStream.range(0, n)
                .mapToLong($ -> f(m))
                .reduce(1, (a, b) -> (a * b) % base);
        gCache.put(m, result);
        return result;
    }

    private static void resetCaches() {
        hCache.clear();
        fCache.clear();
        gCache.clear();
    }
}


