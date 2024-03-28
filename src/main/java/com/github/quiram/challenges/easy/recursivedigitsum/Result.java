package com.github.quiram.challenges.easy.recursivedigitsum;

import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four">Recursive Digit Sum</a>
 */
class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        final long baseReduction = IntStream.range(0, n.length())
                .mapToObj(i -> n.substring(i, i + 1))
                .mapToLong(Long::parseLong)
                .reduce(0, Long::sum);
        final long p = baseReduction * k;

        if (p < 10) {
            return (int) p;
        }

        return superDigit(format("%s", p), 1);
    }

}
