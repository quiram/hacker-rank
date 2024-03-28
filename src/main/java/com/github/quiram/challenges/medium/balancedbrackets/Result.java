package com.github.quiram.challenges.medium.balancedbrackets;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-five">Balanced Brackets</a>
 */
class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> brackets = new Stack<>();
        List<Character> openingBrackets = List.of('(', '[', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (openingBrackets.contains(c)) {
                brackets.push(c);
            } else {
                if (brackets.isEmpty()) {
                    return "NO";
                }

                char b = brackets.pop();
                if (b == '(' && c != ')' ||
                        b == '[' && c != ']' ||
                        b == '{' && c != '}') {
                    return "NO";
                }
            }
        }

        if (brackets.isEmpty()) {
            return "YES";
        }

        return "NO";
    }

}