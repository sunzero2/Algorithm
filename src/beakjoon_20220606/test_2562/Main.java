package beakjoon_20220606.test_2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            if (max < input) {
                index = i;
                max = input;
            }
        }

        System.out.println(max);
        System.out.println(index + 1);
    }
}
