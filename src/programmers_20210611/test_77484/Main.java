package programmers_20210611.test_77484;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(lottos, win_nums)));
    }
}
