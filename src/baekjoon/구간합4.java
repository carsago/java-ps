package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11659 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class 구간합4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countOfNumber = Integer.parseInt(st.nextToken());
        int countOfProblem = Integer.parseInt(st.nextToken());

        int[] sums = new int[countOfNumber+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < countOfNumber; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < countOfProblem; i++) {
            st = new StringTokenizer(br.readLine());

            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            System.out.println(sums[endIdx] - sums[startIdx-1]);
        }
    }
}
