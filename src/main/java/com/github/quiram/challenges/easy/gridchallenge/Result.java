package com.github.quiram.challenges.easy.gridchallenge;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four">Grid Challenge</a>
 */
class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        final List<String> sortedGrid = grid.stream()
                .map(String::toCharArray)
                .peek(Arrays::sort)
                .map(String::new)
                .collect(toList());

        for (int i = 0; i < sortedGrid.get(0).length(); i++) {
            for (int j = 1; j < sortedGrid.size(); j++) {
                if (sortedGrid.get(j).charAt(i) < sortedGrid.get(j - 1).charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

}