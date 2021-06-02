package programmers_20210602.test_42840;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] supoScore = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int tmp = answers[i];

            if (tmp == supo1[i % 5]) {
                supoScore[0]++;
            }

            if (tmp == supo2[i % 8]) {
                supoScore[1]++;
            }

            if (tmp == supo3[i % 10]) {
                supoScore[2]++;
            }
        }

        int max = Math.max(Math.max(supoScore[0], supoScore[1]), supoScore[2]);
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < supoScore.length; i++) {
            if (max == supoScore[i]) {
                tmp.add(i + 1);
            }
        }

        int[] answer = new int[tmp.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}
