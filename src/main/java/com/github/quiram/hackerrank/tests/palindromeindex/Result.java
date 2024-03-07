package com.github.quiram.hackerrank.tests.palindromeindex;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean same = true;

        // already palindrome?
        while (i < j && same) {
            same = s.charAt(i) == s.charAt(j);
            i++;
            j--;
        }

        if (same) {
            return -1;
        }
        int candidateLeftIndex = i - 1;
        int candidateRightIndex = j + 1;

        // Skip one at the beginning
        i = candidateLeftIndex + 1;
        j = candidateRightIndex;
        same = true;
        while (i < j && same) {
            same = s.charAt(i) == s.charAt(j);
            i++;
            j--;
        }

        if (same) {
            return candidateLeftIndex;
        }

        // Skip one at the end
        i = candidateLeftIndex;
        j = candidateRightIndex - 1;
        same = true;
        while (i < j && same) {
            same = s.charAt(i) == s.charAt(j);
            i++;
            j--;
        }

        if (same) {
            return candidateRightIndex;
        }

        return -1;
    }

}