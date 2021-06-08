package test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution3(7));

        int[] grade = {3,2 , 1, 2};
        System.out.println(Arrays.toString(solution.solution2(grade)));

        int n = 3;
        int[] coffeeTimes = {4, 2, 2, 5, 3};
        System.out.println(Arrays.toString(solution.solution4(n, coffeeTimes)));
    }
}
