package com.github.quiram.hackerrank.basic.newyearchaos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void minimumBribes(List<Integer> q, String output) {
        Result.minimumBribes(q);
        assertEquals(output, outContent.toString().trim());
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), "0"),
                Arguments.of(List.of(1, 3, 2, 4), "1"),
                Arguments.of(List.of(3, 2, 1, 4), "3"),
                Arguments.of(List.of(3, 4, 2, 1), "5"),
                Arguments.of(List.of(3, 1, 2, 4), "2"),
                Arguments.of(List.of(3, 1, 4, 2), "3"),
                Arguments.of(List.of(2, 1, 5, 3, 4), "3"),
                Arguments.of(List.of(2, 5, 1, 3, 4), "Too chaotic")

        );
    }
}