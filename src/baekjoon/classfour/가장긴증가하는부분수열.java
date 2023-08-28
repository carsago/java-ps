package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11053
 */
public class 가장긴증가하는부분수열 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n + 1];
        String[] toAdd = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(toAdd[i-1]);
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int max = dp[1];
        for (int i = 2; i < values.length; i++) {
            for (int j = 0; j < i; j++) {
                if (values[j] < values[i] && dp[j] <= dp[i] +1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
