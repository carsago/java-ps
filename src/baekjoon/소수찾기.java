package baekjoon;

import java.util.Scanner;

/**
 * 백준 1978 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */
public class 소수찾기 {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        int answer = 0;

        for (int i = 0; i < count; i++) {
            int value = scanner.nextInt();

            if (value == 1) {
                continue;
            }

            if (isPrimeNumber(value)) {
                answer++;
            }
        }


        System.out.println(answer);
    }

    private static boolean isPrimeNumber(int targetNumber) {
        for (int i = 2; i <= targetNumber / 2; i++) {
            if (targetNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
