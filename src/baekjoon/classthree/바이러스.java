package baekjoon.classthree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2606
 */
public class 바이러스 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        List<Integer>[] map = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < line; i++) {
            String[] s = br.readLine().split(" ");
            int first = Integer.parseInt(s[0]);
            int last = Integer.parseInt(s[1]);
            map[first].add(last);
            map[last].add(first);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int answer = 0;
        boolean[] clear = new boolean[n + 1];
        clear[1] = true;
        while (!queue.isEmpty()) {
            Integer value = queue.poll();

            for (Integer toAdd : map[value]) {
                if (!clear[toAdd]) {
                    clear[toAdd] = true;
                    queue.add(toAdd);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
