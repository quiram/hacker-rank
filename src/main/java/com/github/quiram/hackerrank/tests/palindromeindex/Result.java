package com.github.quiram.hackerrank.tests.palindromeindex;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        if (isPalindrome(s)) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(removeCharAt(s, i))) {
                return i;
            }
        }

        return -1;
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        boolean same = true;
        for (; i < s.length() / 2 && same; i++) {
            same = s.charAt(i) == s.charAt(s.length() - 1 - i);
        }

        return same;
    }

    public static String removeCharAt(String s, int i) {
        return s.substring(0, i) + s.substring(i + 1);
    }

}