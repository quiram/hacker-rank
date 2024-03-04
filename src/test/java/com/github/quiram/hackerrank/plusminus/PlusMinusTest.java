package com.github.quiram.hackerrank.plusminus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlusMinusTest {
    private final PlusMinus subject = new PlusMinus();

    @ParameterizedTest
    @MethodSource("scenarios")
    void testScenarios(List<Integer> arr, List<String> results) {
        assertEquals(results, subject.calculate(arr));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(-4, 3, -9, 0, 4, 1), List.of("0.500000", "0.333333", "0.166667"))
        );
    }
}