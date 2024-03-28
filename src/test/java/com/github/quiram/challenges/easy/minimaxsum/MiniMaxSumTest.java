package com.github.quiram.challenges.easy.minimaxsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiniMaxSumTest {
    private final MiniMaxSum subject = new MiniMaxSum();

    @ParameterizedTest
    @MethodSource("scenarios")
    void testScenarios(List<Integer> arr, List<Long> results) {
        assertEquals(results, subject.calculate(arr));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(1, 3, 5, 7, 9), List.of(16L, 24L)),
                Arguments.of(List.of(256741038, 623958417, 467905213, 714532089, 938071625), List.of(2063136757L, 2744467344L))
        );
    }
}