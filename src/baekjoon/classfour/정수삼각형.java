package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1932
 */
public class 정수삼각형 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                array[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] maxArray = new int[n][n];
        maxArray[n-1] = array[n-1];
        int offset = n-1;
        for (int i = 1; i <= maxArray.length; i++) {
            for (int j = 0; j < offset; j++) {
                maxArray[offset-1][j] = Math.max(maxArray[offset][j], maxArray[offset][j + 1]) + array[offset-1][j];
            }
            offset--;
        }

        System.out.println(maxArray[0][0]);
    }
}
