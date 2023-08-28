package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 평범한배낭 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] weights = new int[K + 1];
        int[] values = new int[N+1];
        for (int i = 1; i <= N; i++) {
            String[] a = br.readLine().split(" ");
            weights[i] = Integer.parseInt(a[0]);
            values[i] = Integer.parseInt(a[1]);
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            int weight = weights[i];
            int value = values[i];
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight] + value);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
