package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2751
 */
public class 수정렬하기2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int round = Integer.parseInt(br.readLine());
        boolean[] array = new boolean[20001];

        for (int i = 0; i < round; i++) {
            array[Integer.parseInt(br.readLine()) + 10000] = true;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                sb.append(i - 10000 + "\n");
            }
        }

        System.out.println(sb);

    }
}
