package programmers_202010601.test_12977;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    for (int k = 0; k < nums.length; k++) {
                        if (j != k && i != k) {
                            int sum = nums[i] + nums[j] + nums[k];
                            if (isPrime(sum) && !results.contains(sum)) {
                                answer++;
                                results.add(sum);
                                System.out.println("[" + nums[i] + "," + nums[j] + "," + nums[k] + "]를 이용해서 " + sum + "을 만들 수 있습니다.");
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);

        for(int i = 2; i <= end; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
