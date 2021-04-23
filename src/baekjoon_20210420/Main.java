package baekjoon_20210420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 8:22 ~ 못풀었다. 플로이드 워셜 알고리즘 찾아보기
// 9:57 ~ 10:32 코드 이해
// 배열 크기를 하나씩 늘리는 것보다 0부터 채우는 것이 메모리나 시간적으로 더 효율적이다.
public class Main {
    static ArrayList<Integer>[] adl;
    static boolean[] visited; // 찾을 노드를 방문했는지 체크하기 위한 배열
    static int[] weight; // 타겟 노드까지 몇 개의 노드를 거쳤는지 체크하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        adl = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adl[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adl[a].add(b);
            adl[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;

        // i : 시작 노드
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // j : 타겟 노드
            for (int j = 0; j < n; j++) {
                if (j != i) { // 자기 자신 찾는 것을 방지하기 위해 if문 씀
                    visited = new boolean[n];
                    weight = new int[n];
                    sum += bfs(i, j);
                }
            }

            if (sum < min) {
                ans = i;
                min = sum;
            }
        }

        System.out.println(ans + 1);
    }

    public static int bfs(int start, int target) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int currentNode = que.poll();

            for (int i = 0; i < adl[currentNode].size(); i++) {
                int next = adl[currentNode].get(i); // next에는 현재 방문한 노드와 관계를 가지고 있는 노드들이 담긴다.
                if (!visited[next]) {
                    weight[next] = weight[currentNode] + 1; // 타겟 노드를 찾기 위해 next 노드들을 방문했다는 것을 체크한다.
                    visited[next] = true;

                    if (next == target) {
                        return weight[next];
                    }

                    que.add(next);
                }
            }
        }

        return 0;
    }

    public static void fail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adl.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (!adl.get(a).contains(b)) {
                adl.get(a).add(b);
                adl.get(b).add(a);
            }
        }

        int[] index = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int tmp = 1;
                if (i == j) continue;

                Queue<Integer> que = new LinkedList<>();
                boolean[] visited = new boolean[n];
                que.addAll(adl.get(i));
                while (!que.isEmpty()) {
                    ++tmp;
                    int relation = que.poll();
                    visited[relation] = true;

                    if (adl.get(relation).contains(j)) {
                        break;
                    } else {
                        for (Integer r : adl.get(relation)) {
                            if (!visited[r] && r != i) {
                                que.add(r);
                            }
                        }
                    }
                }
                count += tmp;
            }
            index[i] = count;
        }

        int min = index[0];
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (index[i] < min) {
                minIdx = i;
            }
        }

        System.out.println(minIdx);
        System.out.println(Arrays.toString(index));
    }
}
