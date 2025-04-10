package baekjoon_20250410.test_11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates.add(new Coordinate(x, y));
        }

        Collections.sort(coordinates);

        StringBuilder sb = new StringBuilder();
        for (Coordinate c : coordinates) {
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }
        System.out.print(sb);
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.y == o.y)
                return this.x - o.x;
            return this.y - o.y;
        }
    }
}
