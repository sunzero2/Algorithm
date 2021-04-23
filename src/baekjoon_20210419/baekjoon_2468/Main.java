package baekjoon_20210419.baekjoon_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 48분 걸렸다.
public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!que.contains(arr[i][j])) {
                    que.add(arr[i][j]);
                }
            }
        }

        int count = 0;
        while (!que.isEmpty()) {
            visited = new boolean[n][n];
            int base = que.poll();
            int tmp = 0;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (!visited[y][x] && base < arr[y][x]) {
                        visited[y][x] = true;
                        ++tmp;
                        visit(x, y, base);
                    }
                }
            }

            count = Math.max(count, tmp); // 이게 if 보다 빠르네..
        }

        System.out.println(count);
    }

    public static void visit(int x, int y, int base) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < arr.length && nextY < arr.length) {
                if (base < arr[nextY][nextX] && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    visit(nextX, nextY, base);
                }
            }
        }
    }
}
