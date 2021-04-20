package baekjoon_20204020;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int n = 4;
        final int INF = 1000000;
        int[][] adj = {
                {0, 5, 7, INF},
                {7, 0, INF, 2},
                {INF, 6, 0, 3},
                {3, 2, INF, 0}};

        /*
        * i : 출발 노드
        * j : 도착 노드
        * k : 거쳐가는 노드
        * */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int k = 0; k < n; k++) {
                        if (adj[i][j] > (adj[i][k] + adj[k][j])) {
                            adj[i][j] = (adj[i][k] + adj[k][j]);
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(adj));
    }
}
