package baekjoon.classfour;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1967
 */
public class 트리의지름2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int checkDistance = 0;
    private static boolean[] clean;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        LinkedList<Node>[] list = new LinkedList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, distance));
            list[end].add(new Node(start, distance));
        }

        int maxDistance = 0;

        for (int i = 1; i < n; i++) {
            clean = new boolean[n + 1];
            clean[i] = true;
            dfs(i,list, 0);
            if (maxDistance < checkDistance) {
                maxDistance = checkDistance;
            }
        }

        System.out.println(maxDistance);
    }

    private static void dfs(int start, LinkedList<Node>[] list, int value) {
        if (checkDistance < value) {
            checkDistance = value;
        }
        for (Node node : list[start]) {
            if (clean[node.next]) {
                continue;
            }
            clean[node.next] = true;
            dfs(node.next, list, value + node.distance);

        }

    }

    public static class Node {
        int next;
        int distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }
}
