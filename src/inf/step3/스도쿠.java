package inf.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[][] n = new int[7][7];
        StringTokenizer st;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                n[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        int[] b = new int[5];

        for (int i = 0; i < 7; i++) {
            int[] q = n[i];
            for (int j = 0; j < 3; j++) {
                b = Arrays.copyOfRange(q, 0 + j, 5 + j);
                if (b[0] == b[4] && b[1] == b[3]) {
                    answer++;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                for (int z = 0; z < 5; z++) {
                    b[z] = n[z+j][i];
                }

                if (b[0] == b[4] && b[1] == b[3]) {
                    answer++;
                }
            }
        }

        System.out.println("answer = " + answer);

    }
}
