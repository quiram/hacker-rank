package com.github.quiram.tests.intermediate.trucktour;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @MethodSource("scenarios")
    void truckTour(List<List<Integer>> petrolpumps, int result) {
        assertEquals(result, Result.truckTour(petrolpumps));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(List.of(1, 5), List.of(10, 3), List.of(3, 4)), 1)
        );
    }
}