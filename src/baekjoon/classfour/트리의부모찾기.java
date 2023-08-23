package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/11725
 */
public class 트리의부모찾기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] father = new int[n + 1];
        map = new LinkedList[n + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            map[a].add(b);
            map[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] clean = new boolean[n + 1];
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            for (Integer next : map[value]) {
                if (clean[next]) {
                    continue;
                }

                queue.add(next);
                clean[next] = true;
                father[next] = value;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 2; i < father.length; i++) {
            sb.append(father[i] + "\n");
        }

        System.out.println(sb);
    }
}
