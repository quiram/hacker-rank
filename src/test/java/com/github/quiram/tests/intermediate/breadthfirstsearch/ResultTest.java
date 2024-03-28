package com.github.quiram.tests.intermediate.breadthfirstsearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @MethodSource("scenarios")
    void bfs(int n, int m, List<List<Integer>> edges, int s, List<Integer> result) {
        assertEquals(result, Result.bfs(n, m, edges, s));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(4, 2, List.of(List.of(1, 2), List.of(1, 3)), 2, List.of(6, 12, -1))
        );
    }
}