package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1865
 */
public class 웜홀 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 5000000;
    private static int[] minDistance;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            int W = Integer.parseInt(a[2]);
            List<Distance>[] map = new LinkedList[N + 1];
            for (int j = 0; j < map.length; j++) {
                map[j] = new LinkedList<>();
            }

            for (int j = 0; j < M; j++) {
                String[] b = br.readLine().split(" ");
                int S = Integer.parseInt(b[0]);
                int E = Integer.parseInt(b[1]);
                int T = Integer.parseInt(b[2]);
                map[S].add(new Distance(E, T));
                map[E].add(new Distance(S, T));
            }

            for (int j = 0; j < W; j++) {
                String[] b = br.readLine().split(" ");
                int S = Integer.parseInt(b[0]);
                int E = Integer.parseInt(b[1]);
                int T = Integer.parseInt(b[2]);
                map[S].add(new Distance(E, T * -1));
            }

            minDistance = new int[N + 1];
            for (int j = 2; j < minDistance.length; j++) {
                minDistance[j] = INF;
            }
            minDistance[1] = 0;
            if (bellmanFord(N, map)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }

        System.out.println(sb);
    }

    private static boolean bellmanFord(int N, List<Distance>[] map) {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < map.length; j++) {
                for (Distance next : map[j]) {
                    int nextDistance = minDistance[j] + next.distance;
                    if (minDistance[next.position] > nextDistance) {
                        minDistance[next.position] = nextDistance;
                    }
                }
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (Distance next : map[i]) {
                if (minDistance[next.position] > next.distance + minDistance[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Distance implements Comparable<Distance> {
        int position;
        int distance;

        public Distance(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
