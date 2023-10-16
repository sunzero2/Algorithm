package beakjoon_20220606.test_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" " )).mapToDouble(Double::valueOf).toArray();
        int max = (int) Arrays.stream(arr).max().getAsDouble();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] / max) * 100;
        }

        System.out.println(Arrays.stream(arr).average().getAsDouble());
    }
}
