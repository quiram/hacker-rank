package com.github.quiram.hackerrank.diagonaldifference;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @ParameterizedTest
    @MethodSource("scenarios")
    void testScenarios(List<List<Integer>> arr, int result) {
        assertEquals(result, Result.diagonalDifference(arr));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of(1, 2, 3),
                        List.of(4, 5, 6),
                        List.of(9, 8, 9)
                ), 2)
        );
    }

}