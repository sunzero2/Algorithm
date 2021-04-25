package baekjoon_20210423;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adl;
    static boolean[] visited;
    static int[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adl = new ArrayList[N];
        finished = new int[N];

        for (int i = 0; i < N; i++) {
            adl[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adl[a].add(b);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, finished[i]);
        }

        for (int i = 0; i < N; i++) {
            if (max == finished[i]) bw.write((i + 1) + " ");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int n : adl[node]) {
            if (!visited[n]) {
                finished[n]++;
                dfs(n);
            }
        }
    }
}
