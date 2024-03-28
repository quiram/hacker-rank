package com.github.quiram.challenges.hard.noprefixset;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-no-prefix-set/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-seven">No Prefix Set</a>
 */
class Result {
    static class TrieNode {
        TrieNode[] next;

        TrieNode() {
            next = new TrieNode[10];
        }
    }

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */
    public static void noPrefix(List<String> words) {
        TrieNode root = new TrieNode();
        // Write your code here
        for (String word : words) {
            TrieNode node = root;
            boolean nodeCreation = false;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    // existing word is prefix of current
                    if (node != root && Arrays.stream(node.next).allMatch(Objects::isNull) && !nodeCreation) {
                        badSet(word);
                        return;
                    }

                    final TrieNode newNode = new TrieNode();
                    node.next[c - 'a'] = newNode;
                    node = newNode;
                    nodeCreation = true;
                } else {
                    node = node.next[c - 'a'];
                }
            }

            // current word is prefix of existing one
            if (!nodeCreation) {
                badSet(word);
                return;
            }
        }

        System.out.println("GOOD SET");
    }

    private static void badSet(String word) {
        System.out.println("BAD SET");
        System.out.println(word);
    }

}