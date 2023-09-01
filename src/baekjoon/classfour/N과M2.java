package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15650
 */
public class N과M2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] array;
    private static boolean[] clear;
    private static int N;
    private static int M;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        array = new int[M];
        dfs(1,0);
        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int value : array) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            array[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
