package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1018
 */
public class 체스판다시칠하기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        boolean[][] board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            for (int j = 0; j < M; j++) {
                if (value.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 8; i <= N; i++) {
            for (int j = 8; j <= M; j++) {
                int min = findMin(board, i, j);
                if (minCount > min) {
                    minCount = min;
                }
            }
        }

        System.out.println(minCount);
    }

    private static int findMin(boolean[][] board, int row, int col) {
        boolean blockColor = true;
        int count = 0;

        for (int i = row - 8; i < row; i++) {
            for (int j = col - 8; j < col; j++) {
                if (board[i][j] != blockColor) {
                    count++;
                }

                blockColor = !blockColor;
            }
            blockColor = !blockColor;

        }
        return Math.min(count, 64 - count);
    }
}
