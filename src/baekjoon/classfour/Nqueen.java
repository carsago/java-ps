package baekjoon.classfour;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9663
 */
public class Nqueen {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        dfs(0);
        System.out.println(answer);

    }

    static int n;
    static int[] map;
    static int answer = 0;

    private static void dfs(int value) {
        if (value == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            map[value] = i;
            if (checkQueen(value)) {
                dfs(value + 1);
            }
        }
    }

    private static boolean checkQueen(int value) {
        for (int i = 0; i < value; i++) {
            if (map[value] == map[i]) {
                return false;
            }

            if (Math.abs(i - value) == Math.abs(map[value] - map[i])) {
                return false;
            }
        }

        return true;
    }

}
