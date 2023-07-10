package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1929
 */
public class 소수구하기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] values = new boolean[M + 1];
        Arrays.fill(values, true);
        for (int i = 2; i <= M; i++) {
            for (int j = 2; i * j <= M; j++) {
                values[i*j] = false;
            }
        }

        values[0] = false;
        values[1] = false;

        for (int i = N; i < values.length; i++) {
            if (values[i]) {
                System.out.println(i);
            }
        }
    }
}
