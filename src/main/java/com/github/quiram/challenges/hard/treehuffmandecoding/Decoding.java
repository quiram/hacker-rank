package com.github.quiram.challenges.hard.treehuffmandecoding;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-tree-huffman-decoding/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-seven">Tree: Huffman Decoding</a>
 */
class Decoding {
    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    void decode(String s, Node root) {
        final StringBuilder sb = new StringBuilder();

        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '0') {
                node = node.left;
            } else {
                node = node.right;
            }

            if (node.data != 0) {
                sb.append(node.data);
                node = root;
            }
        }
        System.out.println(sb);
    }
}
