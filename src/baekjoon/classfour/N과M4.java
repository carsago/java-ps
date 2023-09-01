package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15652
 */
public class N과M4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        answer = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int value : answer) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (depth == 0 || answer[depth - 1] <= i) {
                answer[depth] = i;
                dfs( depth+1);
            }
        }
    }
}
