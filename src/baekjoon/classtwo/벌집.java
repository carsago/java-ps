package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2292
 */
public class 벌집 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int value = 0;
        for (int i = 1; i < n; i++) {

            value = 1 + 3 * (i * (i - 1));
            if (n <= value) {
                System.out.println(i);
                break;
            }
        }
        /**
         * 1
         * 1 + 6 1
         * 1 + 6 + 12 3
         * 1 + 6 + 12 + 18 6
         * 1 + 6 + 12 + 18 +24 = 10
         * a2 =  a1 + (1 * 6)
         * a3 =  a2 + (2 * 6)
         * a4 =  a3 + (3 * 6)
         *
         * an = an-1 + (n-1 * 6)
         * an = a1 + 3(n(n-1))
         */
    }
}
