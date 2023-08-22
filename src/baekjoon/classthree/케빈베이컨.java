package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1389
 */
public class 케빈베이컨 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int userCount = Integer.parseInt(st.nextToken());
        int round = Integer.parseInt(st.nextToken());
        List<Integer>[] values = new LinkedList[round + 1];
        for (int i = 0; i < values.length; i++) {
            values[i] = new LinkedList<>();
        }
        for (int i = 0; i < round; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            values[first].add(last);
            values[last].add(first);
        }


        for (List<Integer> value : values) {
            Collections.sort(value);
        }

        int answerIdx = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= userCount; i++) {
            int answer = 0;
            for (int j = 1; j <= userCount; j++) {
                answer += bfs(values, i, j, userCount);
            }
            if (minValue > answer) {
                answerIdx = i;
                minValue = answer;
            }
        }
        System.out.println(answerIdx);
    }

    private static int bfs(List<Integer>[] values, int start, int end, int userCount) {
        if (start == end) {
            return 0;
        }
        boolean[] clear = new boolean[userCount + 1];
        Queue<Distance> queue = new LinkedList<>();
        queue.add(new Distance(start, 0));
        clear[start] = true;
        int minValue = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Distance target = queue.poll();
            if (target.value == end) {
                if (minValue > target.distance) {
                    minValue = target.distance;
                }
            }

            for (Integer value : values[target.value]) {
                if (!(clear[value])) {
                    clear[value] = true;
                    queue.add(new Distance(value, target.distance + 1));
                }
            }
        }

        return minValue;
    }

    private static class Distance {

        int value;
        int distance;

        public Distance(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }

}
