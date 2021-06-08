package beakjoon_20210609.test_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] param = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int p : param) {
            sum += p;
        }

        System.out.println(sum);
    }
}
