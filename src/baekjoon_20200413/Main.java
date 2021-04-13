package baekjoon_20200413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] bx = {-1, 0, 1, 0};
    static int[] by = {0, -1, 0 ,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 지도의 크기
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    que.add(dfs(j, i));
                }
            }
        }

        Collections.sort(que);
        System.out.println(que.size());

        while (!que.isEmpty()) {
            System.out.println(que.poll());
        }
    }

    public static int dfs(int x, int y) {
        int index = 1;
        arr[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int next_x = x + bx[i];
            int next_y = y + by[i];

            if (next_x >= 0 && next_y >= 0 && next_x < arr.length && next_y < arr.length) {
                if (arr[next_y][next_x] == 1) {
                    index += dfs(next_x, next_y);
                }
            }
        }

        return index;
    }
}
