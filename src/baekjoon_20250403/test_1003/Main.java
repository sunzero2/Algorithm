package baekjoon_20250403.test_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] inputs = new int[count];
        int max = 0;

        for (int i = 0; i < count; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(inputs[i], max);
        }

        int[][] dp = new int[max + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        if (max >= 1) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int input : inputs) {
            System.out.println(dp[input][0] + " " + dp[input][1]);
        }
    }
}
