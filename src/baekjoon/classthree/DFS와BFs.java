package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class DFS와BFs {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuffer bfsAnswer = new StringBuffer();
    private static final StringBuffer dfsAnswer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String[] start = br.readLine().split(" ");
        int N = Integer.parseInt(start[0]);
        int M = Integer.parseInt(start[1]);
        int V = Integer.parseInt(start[2]);

        LinkedList<Integer>[] list = new LinkedList[N+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] values = br.readLine().split(" ");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            list[a].add(b);
            list[b].add(a);
        }

        for (LinkedList<Integer> values : list) {
            Collections.sort(values);
        }

        dfsClear = new boolean[N + 1];
        addDfs(N, V, list);
        addBfs(N, V, list);

        System.out.println(dfsAnswer);
        System.out.println(bfsAnswer);
    }


    static boolean[] dfsClear;

    private static void addDfs(int N, int V, LinkedList<Integer>[] list) {
        dfsClear[V] = true;
        dfsAnswer.append(V + " ");
        for (int i = 0; i < list[V].size(); i++) {
            Integer value = list[V].get(i);
            if (!dfsClear[value]) {
                addDfs(N, value, list);
            }
        }
    }

    private static void addBfs(int N, int V, LinkedList<Integer>[] array) {
        boolean[] clear = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        clear[V] = true;
        bfsAnswer.append(V + " ");
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < array[poll].size(); i++) {
                Integer value = array[poll].get(i);
                if (!clear[value]) {
                    queue.add(value);
                    clear[value] = true;
                    bfsAnswer.append(value + " ");

                }
            }
        }
    }
}
