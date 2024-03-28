package com.github.quiram.challenges.hard.treepreordertraversal;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-tree-preorder-traversal/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-seven">Tree: Preorder Traversal</a>
 */
class Result {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void preOrder(Node root) {
        final StringBuilder sb = new StringBuilder();
        buildOutput(root, sb);
        System.out.println(sb.toString().trim());
    }

    private static void buildOutput(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.data).append(' ');
        buildOutput(node.left, sb);
        buildOutput(node.right, sb);
    }
}
