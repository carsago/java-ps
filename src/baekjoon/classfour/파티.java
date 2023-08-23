package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1238
 */
public class 파티 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static PriorityQueue<Distance> queue = new PriorityQueue<>();
    static List<Distance>[] map;


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int X = Integer.parseInt(s[2]);

        map = new LinkedList[N + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] a = br.readLine().split(" ");
            Distance distance = new Distance(Integer.parseInt(a[1]), Integer.parseInt(a[2]));
            map[Integer.parseInt(a[0])].add(distance);
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int startMin = bfs(i, X);
            int returnMin = bfs(X, i);
            int distance = startMin + returnMin;
            if (answer < distance) {
                answer = distance;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int start, int end) {
        queue.add(new Distance(start, 0));
        boolean[] clean = new boolean[N + 1];
        clean[start] = true;
        int[] minDistance = new int[N + 1];
        minDistance[1] = 0;
        for (int i = 0; i < minDistance.length; i++) {
            if (i != start) {
                minDistance[i] = Integer.MAX_VALUE;
            }
        }
        while (!queue.isEmpty()) {
            Distance distance = queue.poll();
            clean[distance.idx] = true;
            for (Distance next : map[distance.idx]) {
                if (clean[next.idx]) {
                    continue;
                }

                int nextDistance = distance.distance + next.distance;
                if (minDistance[next.idx] > nextDistance) {
                    minDistance[next.idx] = nextDistance;
                    queue.add(new Distance(next.idx, nextDistance));
                }
            }
        }
        return minDistance[end];
    }

    static class Distance implements Comparable<Distance> {
        int idx;
        int distance;

        public Distance(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
