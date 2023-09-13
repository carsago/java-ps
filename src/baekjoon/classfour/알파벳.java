package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/1987
 */
public class 알파벳 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split(" ");
        n = Integer.parseInt(a[0]);
        length = Integer.parseInt(a[1]);
        String[][] map = new String[n][length];
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < strings.length; j++) {
                map[i][j] = strings[j];
            }
        }

        check = getNewCheck();

        dfs(map, -1, 0);
        System.out.println(answer);

    }

    private static Map<String, Boolean> getNewCheck() {
        Map<String, Boolean> check = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            check.put(Character.toString(ch), false);
        }
        return check;
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int length;
    static int number = 0;
    static Map<String, Boolean> check;
    static Integer answer = -100;

    private static void dfs(String[][] map, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int xValue = dx[i] + x;
            int yValue = dy[i] + y;
            if (xValue < 0 || yValue < 0) {
                continue;
            }

            if (xValue >= length || yValue >= n) {
                continue;
            }

            String value = map[yValue][xValue];
            if (check.get(value) == false) {
                check.put(value, true);
                number++;
                if (answer < number) {
                    answer = number;
                }
                dfs(map, xValue, yValue);
                number--;
                check.put(value, false);
            }
        }
    }
}
