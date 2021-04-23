package baekjoon_20210423;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];
        finished = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = 1;
        }

        for (int i = 0; i < N; i++) {
            finished[i] = !visited[i] ? dfs(i) : finished[i];
            visited[i] = true;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = finished[i];

            if (max < cnt) {
                max = cnt;
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
                bw.write(String.valueOf(i + 1));
            } else if (max == cnt) {
                bw.write(" " + (i + 1));
            }
        }

        bw.flush();
        bw.close();
    }

    public static int dfs(int node) {
        int cnt = 0;
        if (!visited[node]) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][node] > 0) {
                    ++cnt;
                    if (!visited[i]) {
                        cnt += dfs(i);
                        visited[i] = true;
                    } else {
                        cnt += finished[i];
                    }
                }
            }

            finished[node] = cnt;
        }

        return cnt;
    }
}
