package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2579
 */
public class 계단오르기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        dp[1] = array[1];

        if (array.length >= 3) {
            dp[2] = array[1] + array[2];
        }

        if (array.length >= 4) {
            dp[3] = Math.max(array[1] + array[3], array[2] + array[3]);
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + array[i - 1]) + array[i];
        }

        System.out.println(dp[n]);
    }
}
