package baekjoon_20250401.test_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = count[0];
        int M = count[1];

        int[][] boj = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(boj[i], Integer.MAX_VALUE);
            boj[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0] - 1;
            int b = input[1] - 1;

            boj[a][b] = 1;
            boj[b][a] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (boj[i][k] != Integer.MAX_VALUE && boj[k][j] != Integer.MAX_VALUE) {
                        boj[i][j] = Math.min(boj[i][j], boj[i][k] + boj[k][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < N; i++) {
            // 8 6 5 5 6
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (boj[i][j] != Integer.MAX_VALUE) {
                    sum += boj[i][j];
                }
            }

            if (sum < min) {
                min = sum;
                result = i + 1;
            }
        }

        System.out.println(result);
    }
}
