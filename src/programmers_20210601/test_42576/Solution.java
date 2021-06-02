package programmers_20210601.test_42576;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> comples = new HashMap<>();

        for (String part : participant) {
            comples.put(part, comples.getOrDefault(part, 0) + 1);
        }

        for (String comple : completion) {
            comples.put(comple, comples.get(comple) - 1);
        }

        for (String key : comples.keySet()) {
            if (comples.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}
