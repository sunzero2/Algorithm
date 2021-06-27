package test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution3(7));

        int[] grade = {3, 2, 1, 2};
        System.out.println(Arrays.toString(solution.solution2(grade)));

        int n = 3;
        int[] coffeeTimes = {4, 2, 2, 5, 3};
        System.out.println(Arrays.toString(solution.solution4(n, coffeeTimes)));

        int[] scores = {80, 90, 90, 100};
        int[] ranks = new int[scores.length];
        ranks[0] = 1;
        for (int i = 1; i < ranks.length; i++) {
            ranks[i] = scores[i] == scores[i - 1] ? ranks[i - 1] : i + 1;
        }

        for (int rank : ranks) {
            System.out.print(rank + " ");
        }

    }
}
