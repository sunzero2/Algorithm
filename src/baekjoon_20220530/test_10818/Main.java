package baekjoon_20220530.test_10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] param = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(param).max().getAsInt();
        int min = Arrays.stream(param).min().getAsInt();

        System.out.println(min + " " + max);
    }
}
