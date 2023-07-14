package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4153
 */
public class 직각삼각형 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] array = new int[3];


            for (int i = 0; i < 3; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            if (array[0] == 0) {
                break;
            }
            Arrays.sort(array);

            if ((array[0] * array[0] + (array[1] * array[1])) == (array[2] * array[2])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }
}
