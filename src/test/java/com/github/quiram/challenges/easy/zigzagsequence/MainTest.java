package com.github.quiram.challenges.easy.zigzagsequence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

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
    void findZigZagSequence(int[] a) {
        Main.findZigZagSequence(a, a.length);
        final List<Integer> output = Arrays.stream(outContent.toString().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
        IntStream.range(1, output.size() / 2)
                .forEach(i -> assertTrue(() -> output.get(i) > output.get(i - 1), format("list: %s; index: %s", output, i)));
        IntStream.range(output.size() / 2 + 1, output.size())
                .forEach(i -> assertTrue(() -> output.get(i) < output.get(i - 1), format("list: %s; index: %s", output, i)));
    }

    public static Stream<int[]> scenarios() {
        return Stream.of(
                new int[]{2, 3, 5, 1, 4}
        );
    }
}