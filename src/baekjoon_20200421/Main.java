package baekjoon_20200421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 50분. 시간 초과난다.
public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            finished = new boolean[N];
            visited = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) - 1;
            }

            cnt = 0;
            for (int j = 0; j < N; j++) {
                dfs(j);
            }

            System.out.println(N - cnt);
        }
    }

    public static void dfs(int node) {
        if (!visited[node]) {
            visited[node] = true;

            if (!visited[arr[node]]) {
                dfs(arr[node]);
            } else {
                if (!finished[arr[node]]) {
                    ++cnt;

                    for (int i = arr[node]; i != node; i = arr[i]) {
                        ++cnt;
                    }
                }
            }

            finished[node] = true;
        }
    }
    /*
    * 1 -> 3 -> 3 // X
    * 2 -> (1 -> 3 -> 3) // X
    * (3 -> 3) // O
    * 4 -> 7 -> 6 -> 4 // O
    * 5 -> (3 -> 3) // X
    * 6 -> (4 -> 7 -> 6) // O
    * (7 -> 6 -> 4 -> 7) // O
    * 이 중복된 애들은 건너뛰고 구하면 돼.
    * */
}
