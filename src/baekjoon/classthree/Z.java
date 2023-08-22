package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 https://www.acmicpc.net/problem/1074
 */
public class Z {

    static int answer = 0;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] values = br.readLine().split(" ");
        int N = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);
        int c = Integer.parseInt(values[2]);

        int value = (int) Math.pow(2, N - 1);
        doSomething(value, c + 1, r + 1);
        System.out.println(answer - 1);
    }

    private static void doSomething(int value, int c, int r) {
        int location = 1;
        if (c > value) {
            location++;
        }

        if (r > value) {
            location += 2;
        }

        if (value == 1) {
            answer += location;
            return;
        }
        answer += value * value * (location - 1);

        if (location == 1) {
            doSomething(value / 2, c, r);
        }

        if (location == 2) {
            doSomething(value / 2, c - value, r);
        }

        if (location == 3) {
            doSomething(value / 2, c, r - value);
        }
        if (location == 4) {
            doSomething(value / 2, c - value, r - value);
        }
    }
}
