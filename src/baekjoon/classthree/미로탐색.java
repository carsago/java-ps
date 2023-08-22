package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2178
 */
public class 미로탐색 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        boolean[][] map = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < strings.length; j++) {
                String value = strings[j];
                if (value.equals("1")) {
                    map[i][j + 1] = true;
                }
            }
        }

        boolean[][] clear = new boolean[N + 1][M + 1];
        Queue<Distance> queue = new LinkedList<>();
        queue.add(new Distance(1, 1, 0));
        clear[1][1] = true;

        while (!queue.isEmpty()) {
            Distance distance = queue.poll();

            int x = distance.x;
            int y = distance.y;

            if (x == N && y == M) {
                System.out.println(distance.distance+1);
            }

            if (x - 1 >= 1) {
                if (!clear[x - 1][y] && map[x - 1][y]) {
                    queue.add(new Distance(x - 1, y, distance.distance + 1));
                    clear[x - 1][y] = true;
                }
            }

            if (y - 1 >= 1) {
                if (!clear[x][y - 1] && map[x][y - 1]) {
                    queue.add(new Distance(x, y - 1, distance.distance + 1));
                    clear[x][y - 1] = true;
                }
            }

            if (x + 1 <= N) {
                if (!clear[x + 1][y] && map[x + 1][y]) {
                    queue.add(new Distance(x + 1, y, distance.distance + 1));
                    clear[x + 1][y] = true;
                }

            }


            if (y+1 <= M) {
                if (!clear[x][y +1] && map[x][y +1]) {
                    queue.add(new Distance(x, y +1, distance.distance + 1));
                    clear[x][y +1] = true;
                }
            }
        }
    }


    static class Distance {
        int x;
        int y;
        int distance;

        public Distance(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
