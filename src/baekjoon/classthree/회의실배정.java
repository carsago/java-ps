package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class 회의실배정 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int[] get = {a, b};
            array[i] = get;
        }


        Arrays.sort(array, (a,b ) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        int count = 0;
        int endTime = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] > endTime) {
                endTime = array[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
