package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/15654
 */
public class N과M5 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] answer;
    static int[] values;
    static boolean[] clean;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        String[] b = br.readLine().split(" ");
        values = new int[N];
        clean = new boolean[N];
        answer = new int[M];
        for (int i = 0; i < b.length; i++) {
            values[i] = Integer.parseInt(b[i]);
        }

        Arrays.sort(values);
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int value : answer) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!clean[i]) {
                clean[i] = true;
                answer[depth] = values[i];
                dfs(depth + 1);
                clean[i] = false;
            }
        }
    }
}
