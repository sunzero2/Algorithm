package programmers_20210601.test_12977;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int size = nums.length;
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                        System.out.println("[" + nums[i] + "," + nums[j] + "," + nums[k] + "]를 이용해서 " + sum + "을 만들 수 있습니다.");
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);

        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
