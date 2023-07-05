package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 14916, 거스름돈 https://www.acmicpc.net/problem/14916
 */
public class 거스름돈 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int money = Integer.parseInt(br.readLine());
        int count = 0;

        // 짝수일 때
        if ((money % 5) % 2 == 0) {
            count += money / 5;
            count += (money % 5) / 2;
        // 1 3 일때
        } else if (money == 1 || money == 3) {
            count = -1;
        // 홀수일 때
        } else {
            // 홀수일 때
            count += (money / 5) -1 ;
            count += (money % 5 + 5) / 2;
        }
        System.out.println(count);
    }
}
