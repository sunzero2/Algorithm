package programmers_20210628;

import java.util.HashSet;

public class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> monsters = new HashSet<>();

        for (int num : nums) {
            monsters.add(num);
        }

        return Math.min(answer, monsters.size());
    }
}
