package baekjoon_20210419.baekjoon_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 24분 걸렸다.
public class Main {
    static String[][] arr;
    static boolean[][] visited;
    static boolean[][] wVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int wCount = 0;
        arr = new String[n][n];
        visited = new boolean[n][n];
        wVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    ++count;
                    dfs(j, i, false);
                }

                if (!wVisited[i][j]) {
                    wVisited[i][j] = true;
                    ++wCount;
                    dfs(j, i, true);
                }
            }
        }

        System.out.println(count + " " + wCount);
    }

    public static void dfs(int x, int y, boolean isWeakness) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < arr.length && nextY < arr.length) {
                if (isWeakness) {
                    if ("GR".contains(arr[y][x])) {
                        if ((arr[nextY][nextX].equals("G") || arr[nextY][nextX].equals("R")) && !wVisited[nextY][nextX]) {
                            wVisited[nextY][nextX] = true;
                            dfs(nextX, nextY, true);
                        }
                    } else {
                        if (arr[nextY][nextX].equals(arr[y][x]) && !wVisited[nextY][nextX]) {
                            wVisited[nextY][nextX] = true;
                            dfs(nextX, nextY, true);
                        }
                    }
                } else {
                    if (arr[y][x].equals(arr[nextY][nextX]) && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        dfs(nextX, nextY, false);
                    }
                }
            }
        }
    }
}
