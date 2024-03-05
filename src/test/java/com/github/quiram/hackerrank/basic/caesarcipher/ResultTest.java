package com.github.quiram.hackerrank.basic.caesarcipher;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @ParameterizedTest
    @CsvSource({
            "a,3,d",
            "middleoutz,2,okffngqwvb",
            "middle-outz,2,okffng-qwvb",
            "middleOutz,2,okffngQwvb",
            "Always-Look-on-the-Bright-Side-of-Life,5,Fqbfdx-Qttp-ts-ymj-Gwnlmy-Xnij-tk-Qnkj",
            "Hello_World!,4,Lipps_Asvph!"
    })
    void caesarCipher(String input, int k, String output) {
        assertEquals(output, Result.caesarCipher(input, k));
    }
}