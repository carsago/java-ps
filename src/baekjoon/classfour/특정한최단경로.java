package baekjoon.classfour;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1504
 */
public class 특정한최단경로 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Distance>[] map;
    private static Queue<Distance> queue = new PriorityQueue<>();
    private static int N;
    private static int U;
    private static int V;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        map = new LinkedList[N + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] a = br.readLine().split(" ");
            int start = Integer.parseInt(a[0]);
            int end = Integer.parseInt(a[1]);
            int distance = Integer.parseInt(a[2]);
            map[start].add(new Distance(end, distance));
            map[end].add(new Distance(start, distance));
        }

        String[] s1 = br.readLine().split(" ");
        U = Integer.parseInt(s1[0]);
        V = Integer.parseInt(s1[1]);

        int firstU = dij(1, U);
        firstU += dij(U, V);
        firstU += dij(V, N);

        int firstV = dij(1, V);
        firstV += dij(V, U);
        firstV += dij(U, N);

        if (firstU >= 200000000) {
            System.out.println(-1);
        } else {
            if (firstU > firstV) {
                System.out.println(firstV);
            } else {
                System.out.println(firstU);
            }
        }
    }

    private static class Distance implements Comparable<Distance> {
        int idx;
        int value;

        public Distance(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Distance other) {
            return Integer.compare(this.value, other.value);
        }
    }

    private static int dij(int start, int end) {
        boolean[] clean = new boolean[N + 1];
        queue.add(new Distance(start, 0));
        clean[start] = true;
        int[] minDistance = new int[N + 1];
        minDistance[start] = 0;
        for (int i = 0; i < minDistance.length; i++) {
            if (i != start) {
                minDistance[i] = 200000000;
            }
        }

        while (!queue.isEmpty()) {
            Distance distance = queue.poll();
            clean[distance.idx] = true;
            for (Distance next : map[distance.idx]) {
                if (clean[next.idx]) {
                    continue;
                }
                int nextDistance = next.value + distance.value;
                if (minDistance[next.idx] > nextDistance) {
                    minDistance[next.idx] = nextDistance;
                    queue.add(new Distance(next.idx, nextDistance));
                }
            }
        }

        return minDistance[end];
    }
}
