package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1541
 */
public class 잃어버린괄호 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] values = br.readLine().split("-");

        int answer = 0;
        for (int i = 0; i < values.length; i++) {
            String[] plus = values[i].split("\\+");
            for (String value : plus) {
                answer -= Integer.parseInt(value);
            }

            if (i == 0) {
                answer *= -1;
            }
        }

        System.out.println(answer);
    }
}
