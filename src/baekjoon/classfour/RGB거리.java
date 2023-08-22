package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1149
 */
public class RGB거리 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] blokcs = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                blokcs[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] dp = new int[n][3];
        dp[0][0] = blokcs[0][0];
        dp[0][1] = blokcs[0][1];
        dp[0][2] = blokcs[0][2];

        doDp(n-1, blokcs, dp);
        System.out.println( Arrays.stream(dp[n - 1]).min()
                .getAsInt());
    }

    private static void doDp(int n, int[][] blokcs, int[][] dp) {
        if (dp[n-1][0] == 0) {
            doDp(n-1, blokcs, dp);
        }
        dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + blokcs[n][0];
        dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + blokcs[n][1];
        dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + blokcs[n][2];
    }
}
