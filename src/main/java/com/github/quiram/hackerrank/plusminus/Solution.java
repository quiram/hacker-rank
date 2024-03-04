package com.github.quiram.hackerrank.plusminus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        final List<String> results = new PlusMinus().calculate(arr);
        results.forEach(System.out::println);
    }

}

class PlusMinus {
    List<String> calculate(List<Integer> arr) {
        final int n = arr.size();
        final int[] count = new int[3];
        arr.stream().mapToInt(x -> {
            if (x > 0) {
                return 0;
            } else if (x < 0) {
                return 1;
            } else {
                return 2;
            }
        }).forEach(i -> count[i]++);

        return IntStream.range(0, 3)
                .mapToDouble(i -> count[i] * 1.0 / n)
                .mapToObj(f -> String.format("%.6f", f))
                .collect(toList());
    }
}

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one">Plus Minus
 * </a>
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
