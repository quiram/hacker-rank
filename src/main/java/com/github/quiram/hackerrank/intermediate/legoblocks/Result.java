package com.github.quiram.hackerrank.intermediate.legoblocks;

import java.util.HashSet;
import java.util.Set;

class Result {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    private static Set<String> combinations;

    public static int legoBlocks(int n, int m) {
        combinations = new HashSet<>();

        // Write your code here
        //  n = 2;
        generate(0, new StringBuilder(), m);

        if (n == 1) {
            return combinations.size();
        }

        int count = 0;

        for (String c1 : combinations) {
            for (String c2 : combinations) {
                int p1 = 0;
                int p2 = 0;
                boolean compatible = true;
                for (int i = 0; i < c1.length() && i < c2.length() && compatible && c1.length() > 1; i++) {
                    p1 += Integer.parseInt("" + c1.charAt(i));
                    p2 += Integer.parseInt("" + c2.charAt(i));
                    compatible = p1 != p2;
                }
                if (compatible) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void generate(int partial, StringBuilder sb, int m) {
        if (partial == m) {
            combinations.add(sb.toString());
        }

        if (partial > m) {
            return;
        }

        for (int i = 1; i <= 4; i++) {
            generate(partial + i, sb.append(i), m);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

}
