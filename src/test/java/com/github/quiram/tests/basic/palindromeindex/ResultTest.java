package com.github.quiram.tests.basic.palindromeindex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @CsvSource({
            "aaab,3",
            "baa,0",
            "aa,-1",
            "2345678,-1"
    })
    void palindromeIndex(String s, int index) {
        assertEquals(index, Result.palindromeIndex(s));
    }
}