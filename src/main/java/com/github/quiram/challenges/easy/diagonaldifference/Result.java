package com.github.quiram.challenges.easy.diagonaldifference;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two">Diagonal Difference</a>
 */
class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        final int result = IntStream.range(0, arr.size())
                .map(i -> {
                    List<Integer> sublist = arr.get(i);
                    return sublist.get(i) - sublist.get(sublist.size() - i - 1);
                })
                .reduce(0, Integer::sum);

        return Math.abs(result);
    }

}
