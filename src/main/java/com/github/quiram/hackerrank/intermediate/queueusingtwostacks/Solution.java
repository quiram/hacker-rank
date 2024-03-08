package com.github.quiram.hackerrank.intermediate.queueusingtwostacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-five">Queue Using Two Stacks</a>
 */
public class Solution {
    public static class Queue {
        private final Stack<Integer> enqueingStack;
        private final Stack<Integer> dequeingStack;

        public Queue() {
            enqueingStack = new Stack<>();
            dequeingStack = new Stack<>();
        }

        public void enqueue(int i) {
            enqueingStack.push(i);
        }

        public void dequeue() {
            switchToDequeuingStack();
            dequeingStack.pop();
        }

        public int getFirst() {
            switchToDequeuingStack();
            return dequeingStack.peek();
        }

        private void switchToDequeuingStack() {
            if (dequeingStack.isEmpty()) {
                while (!enqueingStack.isEmpty()) {
                    dequeingStack.push(enqueingStack.pop());
                }
            }
        }
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> {
                    int n = scanner.nextInt();
                    queue.enqueue(n);
                }
                case 2 -> queue.dequeue();
                case 3 -> System.out.println(queue.getFirst());
            }
        }
    }
}