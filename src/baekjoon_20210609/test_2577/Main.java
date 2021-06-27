package baekjoon_20210609.test_2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int multiplication = A * B * C;
        int[] tmp = Arrays.stream(String.valueOf(multiplication).split("")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[10];

        for (int i : tmp) {
            result[i]++;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
