package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11050
 */
public class 이항계수1 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] values = br.readLine().split(" ");
        int n = Integer.parseInt(values[0]);
        int k = Integer.parseInt(values[1]);

        int value = 1;
        for (int i = n - k + 1; i <= n; i++) {
            value *= i;
        }

        for (int i = 1; i <= k; i++) {
            value /= i;
        }

        System.out.println(value);

    }
}
