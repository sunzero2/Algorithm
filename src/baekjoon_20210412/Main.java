package baekjoon_20210412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[][] check;
    static int[] bx = {-1, 0, 1, 0};
    static int[] by = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        check = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(n, m);
    }

    public static void bfs(int n, int m) {
        LinkedList<Position> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    que.add(new Position(j, i));
                    visited[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            Position tmp = que.pollFirst();

            for (int i = 0; i < 4; i++) {
                int next_x = tmp.x + bx[i];
                int next_y = tmp.y + by[i];

                if (next_x >= 0 && next_y >= 0 && next_x < m && next_y < n) {
                    if (arr[next_y][next_x] == 0 && !visited[next_y][next_x]) {
                        visited[next_y][next_x] = true;
                        arr[next_y][next_x] = 1;
                        check[next_y][next_x] = check[tmp.y][tmp.x] + 1;
                        que.add(new Position(next_x, next_y));
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, check[i][j]);
            }
        }

        System.out.println(max);
    }

    private static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
