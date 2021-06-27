package programmers_20210611.test_77484;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6, 6};
        boolean[] visited = new boolean[win_nums.length];

        int min = 0;
        int zero = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            }

            for (int j = 0; j < lottos.length; j++) {
                if (!visited[j] && (lotto == win_nums[j])) {
                    visited[j] = true;
                    min++;
                }
            }
        }

        Map<Integer, Integer> rank = new HashMap<>();
        rank.put(0, 6);

        for (int i = 1; i < 7; i++) {
            rank.put(i, (7 - i));
        }

        answer[0] = rank.get(min + zero);
        answer[1] = rank.get(min);

        return answer;
    }
}
