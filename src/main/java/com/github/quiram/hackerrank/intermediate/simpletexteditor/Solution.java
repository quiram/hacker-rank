package com.github.quiram.hackerrank.intermediate.simpletexteditor;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static final StringBuilder sb = new StringBuilder();
    private static final Stack<Object> undoStack = new Stack<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            int k;

            switch (op) {
                case 1 -> {
                    String newText = scanner.next();
                    sb.append(newText);
                    undoStack.push(newText.length());
                }
                case 2 -> {
                    k = scanner.nextInt();
                    undoStack.push(sb.substring(sb.length() - k));
                    sb.delete(sb.length() - k, sb.length());
                }
                case 3 -> {
                    k = scanner.nextInt();
                    System.out.println(sb.charAt(k - 1));
                }
                case 4 -> {
                    Object undoOp = undoStack.pop();
                    if (undoOp instanceof Integer) {
                        k = (Integer) undoOp;
                        sb.delete(sb.length() - k, sb.length());
                    } else if (undoOp instanceof String) {
                        sb.append((String) undoOp);
                    }
                }
                default -> System.err.printf("Operation %s not recognised%n", op);
            }
        }
    }

}