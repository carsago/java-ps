package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15649
 */
public class N과M {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] array;
    private static boolean[] clear;
    private static int N;
    private static int M;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        array = new int[M];
        clear = new boolean[N + 1];

        dfs(0);
        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int value : array) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!clear[i]) {
                array[depth] = i;
                clear[i] = true;
                dfs(depth + 1);
                clear[i] = false;
            }
        }
    }
}
