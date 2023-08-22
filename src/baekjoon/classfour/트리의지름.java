package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1167
 */
public class 트리의지름 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Distance>[] map = new LinkedList[n + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int value = Integer.parseInt(s[0]);
            for (int j = 1; j < s.length - 1; j += 2) {
                int x = Integer.parseInt(s[j]);
                int distance = Integer.parseInt(s[j + 1]);
                map[value].add(new Distance(x, distance));
            }
        }

        int maxValue = getMaxValueBybfs(n, map, 1);
        getMaxValueBybfs(n, map, maxValue);
        System.out.println(max);
    }

    private static int getMaxValueBybfs(int n, List<Distance>[] map, int value) {
        int maxValue = 0;
        Queue<Distance> queue = new LinkedList<>();
        queue.add(new Distance(value, 0));
        boolean[] clean = new boolean[n + 1];
        clean[value] = true;
        while (!queue.isEmpty()) {
            Distance distance = queue.poll();
            if (max < distance.distance) {
                max = distance.distance;
                maxValue = distance.value;
            }
            for (Distance next : map[distance.value]) {
                if (!clean[next.value]) {
                    queue.add(new Distance(next.value, distance.distance + next.distance));
                    clean[next.value] = true;
                }
            }
        }
        return maxValue;
    }

    static class Distance {
        int value;
        int distance;

        public Distance(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}
