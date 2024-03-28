package com.github.quiram.challenges.easy.caesarcipher;

import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-caesar-cipher-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-three">Caesar Cipher</a>
 */
class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        final StringBuilder sb = new StringBuilder();
        IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .map(c -> {
                    if (c >= 'a' && c <= 'z') {
                        return (char) ((c - 'a' + k) % 26 + 'a');
                    } else if (c >= 'A' && c <= 'Z') {
                        return (char) ((c - 'A' + k) % 26 + 'A');
                    } else {
                        return c;
                    }
                })
                .forEach(sb::append);
        return sb.toString();
    }

}