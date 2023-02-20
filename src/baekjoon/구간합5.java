package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 구간 합 구하기 5
 * https://www.acmicpc.net/problem/116602
 */
public class 구간합5 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arraySize = Integer.parseInt(st.nextToken());
        int countOfProblem = Integer.parseInt(st.nextToken());

        int[][] sums = new int[arraySize + 1][arraySize + 1];
        int[][] array = new int[arraySize + 1][arraySize + 1];

        for (int i = 1; i < arraySize + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arraySize + 1; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < arraySize + 1; i++) {
            for (int j = 1; j < arraySize + 1; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + array[i][j];
            }
        }

        for (int i = 0; i < countOfProblem; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sums[x2][y2] - sums[x1 - 1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1]);
        }
    }
}
