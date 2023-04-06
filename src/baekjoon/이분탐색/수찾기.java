package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920 수 찾기, https://www.acmicpc.net/problem/1920
 */
public class 수찾기 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        final int round = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < round; i++) {
            final int question = Integer.parseInt(st.nextToken());
            printIfContain(list, question);
        }
    }

    private static void printIfContain(final int[] list, final int question) {
        if (question > list[list.length - 1]) {
            System.out.println("0");
            return;
        }

        if (list[list.length / 2] > question) {
            for (int i = 0; i < list.length / 2; i++) {
                if (list[i] == question) {
                    System.out.println("1");
                    return;
                }
            }
        } else {
            for (int i = list.length / 2; i < list.length; i++) {
                if (list[i] == question) {
                    System.out.println("1");
                    return;
                }
            }
        }

        System.out.println("0");
    }
}
