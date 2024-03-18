package com.github.quiram.hackerrank.tests.intermediate.breadthfirstsearch;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

class Result {
    private static boolean[] visited;
    private static int[] steps;
    private static Map<Integer, Set<Integer>> connections;

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n - number of nodes
     *  2. INTEGER m - number of edges
     *  3. 2D_INTEGER_ARRAY edges - edges from-to
     *  4. INTEGER s - starting node
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        visited = new boolean[n];
        steps = new int[n];
        connections = new HashMap<>();

        edges.forEach(edge -> {
            final Integer a = edge.get(0);
            final Integer b = edge.get(1);
            registerEdge(a, b);
            registerEdge(b, a);
        });
        explore(singleton(s), 0);

        return IntStream.range(0, n)
                .filter(i -> i != s - 1)
                .map(i -> steps[i])
                .map(i -> i == 0 ? -1 : 6 * i)
                .boxed()
                .collect(toList());
    }

    private static void registerEdge(Integer a, Integer b) {
        connections.computeIfAbsent(a, k -> new HashSet<>()).add(b);
    }

    private static void explore(Set<Integer> nodes, int depth) {
        final Set<Integer> effectiveSet = nodes.stream()
                .filter(node -> !visited[node - 1])
                .collect(toSet());

        if (effectiveSet.isEmpty()) {
            return;
        }

        final Set<Integer> nextLevelCandidates = effectiveSet.stream()
                .peek(node -> {
                    int nodeIndex = node - 1;
                    visited[nodeIndex] = true;
                    steps[nodeIndex] = depth;
                })
                .map(node -> connections.getOrDefault(node, emptySet()))
                .flatMap(Set::stream)
                .collect(toSet());

        explore(nextLevelCandidates, depth + 1);
    }

}