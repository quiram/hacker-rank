package com.github.quiram.hackerrank.basic.gridchallenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @MethodSource("scenarios")
    void gridChallenge(List<String> input, String result) {
        assertEquals(result, Result.gridChallenge(input));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv"), "YES"),
                Arguments.of(List.of("xyz", "abc"), "NO"),
                Arguments.of(List.of("xy", "ab"), "NO"),
                Arguments.of(List.of("x", "a"), "NO"),
                Arguments.of(List.of("abc", "lmp", "qrt"), "YES"),
                Arguments.of(List.of("mpxz", "abcd", "wlmf"), "NO"),
                Arguments.of(List.of("abc", "hjk", "mpq", "rtv"), "YES")
        );
    }
}