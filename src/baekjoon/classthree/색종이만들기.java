package baekjoon.classthree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2630
 */
public class 색종이만들기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < values.length; j++) {
                map[i][j] = Integer.parseInt(values[j]);
            }
        }

        check(map, 0, 0, map.length);
        System.out.println(white);
        System.out.println(blue);
    }

    /**
     * x 0 ~ 1 y 0 ~ 1
     * <p>
     * x 0 ~ 1 y 2 - 3
     * <p>
     * x 2 ~ 3 y 0 ~ 1
     * <p>
     * x 2 ~ 3 y 2 ~3
     */
    private static void check(int[][] map, int x, int y, int size) {
        int sum = 0;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y +size   ; j++) {
                sum += map[i][j];
            }
        }

        if (sum == size * size) {
            blue++;
        } else if (sum == 0) {
            white++;
        } else {
            size = size / 2;
            check(map, x+size, y, size);
            check(map, x, y, size);
            check(map, x, y+size, size);
            check(map, x + size, y + size, size);
        }
    }
}
