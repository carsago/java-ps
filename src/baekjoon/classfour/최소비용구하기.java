package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1916
 */
public class 최소비용구하기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Distance>[] map = new LinkedList[N + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map[start].add(new Distance(distance, end));
        }
        String[] a = br.readLine().split(" ");
        int start = Integer.parseInt(a[0]);
        int end = Integer.parseInt(a[1]);
        Queue<Distance> queue = new PriorityQueue<>();
        queue.add(new Distance(0, start));
        boolean[] clean = new boolean[N + 1];
        int[] minDistance = new int[N + 1];
        for (int i = 0; i < minDistance.length; i++) {
            if (i == start) {
                minDistance[i] = 0;
            } else {
                minDistance[i] = Integer.MAX_VALUE;
            }
        }
        while (!queue.isEmpty()) {
            Distance distance = queue.poll();
            clean[distance.position] = true;
            if (minDistance[distance.position] < distance.distance) {
                continue;
            }

            for (Distance next : map[distance.position]) {
                if (clean[next.position]) {
                    continue;
                }

                int nextDistance = distance.distance + next.distance;
                if (nextDistance < minDistance[next.position]) {
                    minDistance[next.position] = nextDistance;
                    queue.add(new Distance(nextDistance, next.position));
                }
            }
        }

        System.out.println(minDistance[end]);
    }


    static class Distance implements Comparable<Distance> {
        int distance;
        int position;

        public Distance(int distance, int position) {
            this.distance = distance;
            this.position = position;
        }

        @Override
        public int compareTo(Distance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
