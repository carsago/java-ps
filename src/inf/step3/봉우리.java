package inf.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봉우리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int countOfNumber = Integer.parseInt(br.readLine());
        int[][] M = new int[countOfNumber+2][countOfNumber+2];

        StringTokenizer st;
        for (int i = 1; i < countOfNumber+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < countOfNumber+1; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
                M[0][j] = 0;
                M[countOfNumber+1][j] = 0;
            }
            M[i][0] = 0;
            M[i][countOfNumber+1] = 0;
        }

        int answer = 0;

        int start = 1;
        int end = countOfNumber+1;

        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                int value = M[i][j];

                if (value > M[i - 1][j] && value > M[i][j - 1] && value > M[i + 1][j] && value > M[i][j + 1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
