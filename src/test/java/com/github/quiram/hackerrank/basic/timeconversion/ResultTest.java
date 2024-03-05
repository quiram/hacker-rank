package com.github.quiram.hackerrank.basic.timeconversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @ParameterizedTest
    @CsvSource("""
            07:05:45PM,19:05:45
            12:05:27AM,00:05:27
            12:09:12PM,12:09:12
            """)
    void testScenarios(String input, String result) {
        assertEquals(result, Result.timeConversion(input));
    }
}