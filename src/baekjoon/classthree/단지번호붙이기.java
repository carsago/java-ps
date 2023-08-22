package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2667
 */
public class 단지번호붙이기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int[][] map;
    static boolean[][] clean;
    static int n;
    static List<Integer> answers = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < s.length; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        clean = new boolean[n][n];

        for (int i = 0; i < clean.length; i++) {
            for (int j = 0; j < clean.length; j++) {
                if (!clean[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answers);
        StringBuffer sb = new StringBuffer();
        for (Integer answer : answers) {
            sb.append(answer + " \n");
        }
        System.out.println(answers.size());
        System.out.println(sb);

    }

    private static void bfs(int x, int y) {
        Queue<Value> queue = new LinkedList<>();
        queue.add(new Value(x,y));
        clean[x][y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Value value = queue.poll();
            int valueX = value.x;
            int valueY = value.y;
            count++;

            for (int i = 0; i < 4; i++) {
                int ax = valueX + dx[i];
                int ay = valueY + dy[i];
                if (ax >= 0 && ay >= 0 && ax < n && ay < n) {
                    if (!clean[ax][ay] && map[ax][ay] == 1) {
                        queue.add(new Value(ax, ay));
                        clean[ax][ay] = true;
                    }
                }
            }

        }
        answers.add(count);
    }

    static class Value {
        int x;
        int y;

        public Value(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
