package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 */
public class 유기농배추_dfs {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int problems = Integer.parseInt(br.readLine());

        for (int i = 0; i < problems; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            array = new boolean[M][N];
            int z = Integer.parseInt(st.nextToken());
            visit = new boolean[M][N];

            for (int j = 0; j < z; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                array[first][second] = true;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (array[j][k] && !visit[j][k]) {
                        dfs(j, k);
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }
    }

    static int M;
    static int N;
    static boolean[][] array;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (!visit[cx][cy] && array[cx][cy]) {
                    dfs(cx,cy);
                }
            }
        }
    }
}
