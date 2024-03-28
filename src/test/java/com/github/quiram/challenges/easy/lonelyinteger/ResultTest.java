package com.github.quiram.challenges.easy.lonelyinteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @ParameterizedTest
    @MethodSource("scenarios")
    void testScenarios(List<Integer> arr, int result) {
        assertEquals(result, Result.lonelyinteger(arr));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 3, 2, 1), 4)
        );
    }

}