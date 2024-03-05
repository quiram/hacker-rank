package com.github.quiram.hackerrank.tests.palindromeindex;

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

    @ParameterizedTest
    @CsvSource({
            "aaab,false",
            "baa,false",
            "aa,true",
            "aba,true"
    })
    void isPalindrome(String s, boolean isPalindrome) {
        assertEquals(isPalindrome, Result.isPalindrome(s));
    }

    @ParameterizedTest
    @CsvSource({
            "aaab,1,aab",
            "baa,1,ba",
            "aa,1,a",
            "aba,1,aa",
            "abc,0,bc",
            "abc,2,ab"
    })
    void removeCharAT(String input, int i, String result) {
        assertEquals(result, Result.removeCharAt(input, i));
    }
}