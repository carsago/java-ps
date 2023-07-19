package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class 프린터큐 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            String[] strings = br.readLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int order = Integer.parseInt(strings[1]);
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            boolean deletable = true;

            int removeCount = 0;
            while (!queue.isEmpty()) {
                int pollValue = queue.poll();

                for (Integer value : queue) {
                    if (pollValue < value) {
                        deletable = false;
                    }
                }

                if (!deletable) {
                    queue.offer(pollValue);
                    if (order == 0) {
                        order = queue.size();
                    }
                } else {
                    removeCount++;
                    if (order == 0) {
                        break;
                    }
                }

                order--;
                deletable = true;
            }
            System.out.println(removeCount);
        }
    }
}
