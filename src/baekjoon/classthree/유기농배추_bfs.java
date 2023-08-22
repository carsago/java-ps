package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_bfs {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int problems = Integer.parseInt(br.readLine());

        for (int round = 0; round < problems; round++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] array = new boolean[M][N];
            boolean[][] visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                String[] values = br.readLine().split(" ");
                array[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = true;
            }
        }
    }

}
