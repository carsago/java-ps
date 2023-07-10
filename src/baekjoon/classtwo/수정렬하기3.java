package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10989
 */
public class 수정렬하기3 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // CountingSort 더 빠르고 메모리 덜든다.
    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(round);
        int[] values = new int[10001];
        for (int i = 0; i < round; i++) {
            values[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                for (int j = 0; j < values[i]; j++) {
                    sb.append(i +"\n");
                }
            }
        }

        System.out.println(sb);
    }

    // raw한 방법
    public static void sort() throws IOException {
        int round = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(round);
        int[] values = new int[round];
        for (int i = 0; i < round; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(values);
        for (Integer value : values) {
            sb.append(value +"\n");
        }

        System.out.println(sb);
    }
}
