package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2164
 */
public class 카드2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> values = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            values.offer(i);
        }

        while (values.size()  != 1) {
            values.poll();
            values.offer(values.poll());
        }

        System.out.println(values.poll());
    }
}
