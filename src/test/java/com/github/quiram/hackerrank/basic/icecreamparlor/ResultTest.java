package com.github.quiram.hackerrank.basic.icecreamparlor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @CsvFileSource(resources = "icecreamParlorTestCases.csv", delimiter = '|', maxCharsPerColumn = 7100)
    void icecreamParlor(String csvLine) {
        final int[] numbers = Arrays.stream(csvLine.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        int m = numbers[0];
        List<Integer> result = List.of(numbers[1], numbers[2]);
        final List<Integer> arr = Arrays.stream(numbers, 3, numbers.length)
                .boxed()
                .collect(toList());

        assertEquals(result, Result.icecreamParlor(m, arr));

    }
}