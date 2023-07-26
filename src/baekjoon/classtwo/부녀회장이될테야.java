package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2775
 */
public class 부녀회장이될테야 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[][] array = new int[15][15];


        for (int i = 1; i <= 14; i++) {
            array[i][0] = i;
            array[1][i] = 1;
        }

        for (int i = 2; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }

        int round = Integer.parseInt(br.readLine());
        for (int i = 0; i < round; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(array[n][k]);
        }
    }
}
