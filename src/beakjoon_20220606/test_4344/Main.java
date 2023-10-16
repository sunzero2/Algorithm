package beakjoon_20220606.test_4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int[] studentScoreArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).skip(1).toArray();
            int average = (int) Math.round(Arrays.stream(studentScoreArr).average().getAsDouble());
            double percentage = ((double) Arrays.stream(studentScoreArr).filter(score -> score > average).count() / studentScoreArr.length) * 100;
            System.out.printf("%.3f%%\n", percentage);
        }
    }
}
