package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/18110
 */
public class solvedac {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        long removeCount = Math.round(n * 0.15);
        for (long i = 0; i < removeCount; i++) {
            list.remove(list.size() - 1);
            list.remove(0);
        }

        int answer = 0;
        for (Integer value : list) {
            answer += value;
        }

        System.out.println(Math.round(answer / (double) list.size()));
    }
}
