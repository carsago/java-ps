package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2839
 */
public class 설탕배달 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                N = 0;
                break;
            }

            N -= 3;
            answer++;
        }

        if (N == 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
