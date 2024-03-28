package com.github.quiram.challenges.easy.countingsort1;


import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-countingsort1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-two">Counting Sort 1</a>
 */
class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        final int[] frequencies = new int[100];
        arr.forEach(i -> frequencies[i]++);

        return Arrays.stream(frequencies).boxed().collect(toList());
    }

}