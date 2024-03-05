package com.github.quiram.hackerrank.basic.minimaxsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        final List<Long> results = new MiniMaxSum().calculate(arr);
        System.out.printf("%s %s", results.get(0), results.get(1));
    }

}

class MiniMaxSum {
    List<Long> calculate(List<Integer> arr) {
        final Integer max = arr.stream().max(naturalOrder()).orElseThrow();
        final Integer min = arr.stream().min(naturalOrder()).orElseThrow();
        final Long total = arr.stream().mapToLong(i -> i).reduce(0L, Long::sum);

        return List.of(total - max, total - min);
    }
}

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one">Mini-Max Sum</a>
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
