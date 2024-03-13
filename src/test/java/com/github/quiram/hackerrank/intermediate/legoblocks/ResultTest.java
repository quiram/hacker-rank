package com.github.quiram.hackerrank.intermediate.legoblocks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @CsvSource({
            "1,1,1",
            "1,2,1",
            "1,3,1",
            "1,4,1",
            "2,2,3",
            "2,3,9",
            "3,2,7",
            "4,4,3375"
    })
    void legoBlocks(int n, int m, int result) {
        final int actual = Result.legoBlocks(n, m);
        assertEquals(result, actual);
    }
}