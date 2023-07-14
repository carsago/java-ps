package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2798
 */
public class 블랙잭 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int current = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N ; j++) {
                for (int k = j + 1; k < N; k++) {
                    int value = values[i] + values[j] + values[k];
                    if (value <= M && value > current) {
                        current = value;
                    }
                }
            }
        }

        System.out.println(current);
    }
}
