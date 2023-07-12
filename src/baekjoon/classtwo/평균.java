package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1546
 */
public class 평균 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int round = Integer.parseInt(br.readLine());
        int[] values = new int[3];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < round; i++) {
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;
            if (max < value) {
                max = value;
            }
        }

        double sum = 0.0;
        for (int value : values) {
            sum += value / (double) max * 100;
        }

        System.out.println(sum/ round);
    }
}
