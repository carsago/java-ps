package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2231
 */
public class 분해합 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        boolean answer = false;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            String strValue = String.valueOf(i);
            sum = i;
            for (int j = 0; j < strValue.length(); j++) {
                sum += Integer.parseInt(String.valueOf(strValue.charAt(j)));
            }
            if (sum == n) {
                answer = true;
                sum = i;
                break;
            }
        }

        if (answer) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}
