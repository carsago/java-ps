package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1436
 */
public class 영화감독숍 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine());

        int value = 667;
        int target = 1;
        while (number != target) {
            value++;

            if (String.valueOf(value).contains("666")) {
                target++;
            }

        }
        System.out.println(value);
    }
}
