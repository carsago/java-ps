package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1753
 */
public class 최단경로 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int round = Integer.parseInt(s[1]);
        int find = Integer.parseInt(br.readLine());
        List<Distance>[] map = new LinkedList[n + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < round; i++) {
            String[] a = br.readLine().split(" ");
            int start = Integer.parseInt(a[0]);
            int end = Integer.parseInt(a[1]);
            int distance = Integer.parseInt(a[2]);
            map[start].add(new Distance(end, distance));
        }

        Queue<Distance> queue =  new PriorityQueue<>();
        queue.add(new Distance(find, 0));
        boolean[] clean = new boolean[n + 1];
        clean[find] = true;
        int[] minDistance = new int[n + 1];
        for (int i = 0; i < minDistance.length; i++) {
            if (i == find) {
                minDistance[find] = 0;
            } else {
                minDistance[i] = 3000001;
            }
        }
        while (!queue.isEmpty()) {
            Distance distance = queue.poll();
            for (Distance next : map[distance.goal]) {
                if (clean[next.goal]) {
                    continue;
                }
                int nextDistance = distance.distance + next.distance;
                if (minDistance[next.goal] > nextDistance) {
                    minDistance[next.goal] = nextDistance;
                    queue.add(new Distance(next.goal, nextDistance));
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < minDistance.length; i++) {
            if (minDistance[i] == 3000001) {
                sb.append("INF\n");
            } else {
                sb.append(minDistance[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Distance implements Comparable<Distance> {
        int goal;
        int distance;

        public Distance(int goal, int distance) {
            this.goal = goal;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
