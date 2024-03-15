package com.github.quiram.hackerrank.intermediate.jesseandcookies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @ParameterizedTest
    @MethodSource("scenarios")
    void cookies(int k, List<Integer> A, int result) {
        assertEquals(result, Result.cookies(k, A));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(10, List.of(1, 1, 1), -1),
                Arguments.of(90, List.of(13, 47, 74, 12, 89, 74, 18, 38), 5),
                Arguments.of(3581, List.of(6214, 8543, 9266, 1150, 7498, 7209, 9398, 1529, 1032, 7384, 6784, 34, 1449, 7598, 8795, 756, 7803, 4112, 298, 4967, 1261, 1724, 4272, 1100, 9373), 7)
        );
    }
}