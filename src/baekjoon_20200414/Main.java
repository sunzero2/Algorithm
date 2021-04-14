package baekjoon_20200414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 세로
        int n = Integer.parseInt(st.nextToken()); // 가로
        int k = Integer.parseInt(st.nextToken()); // 사각형 개수
        arr = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    ++arr[y][x];
                }
            }
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    que.add(dfs(j, i));
                }
            }
        }

        System.out.println(que.size());
        while (!que.isEmpty()) {
            System.out.print(que.poll() + " ");
        }
    }

    public static int dfs(int x, int y) {
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < arr[y].length && nextY < arr.length) {
                if (arr[nextY][nextX] == 0) {
                    arr[nextY][nextX] = 1;
                    count += dfs(nextX, nextY);
                }
            }
        }

        return count;
    }
}
