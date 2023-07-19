package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/11866
 */
public class 요세푸스문제0 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] value = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(value[0]);
        int k = Integer.parseInt(value[1]);

        List<Integer> values = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            values.add(i);
        }

        int[] answer = new int[n];

        int currentIdx = -1;

        for (int i = 0; i < n; i++) {
            currentIdx += k;
            while (currentIdx >= values.size()) {
                currentIdx -= values.size();
            }
            answer[i] = values.remove(currentIdx);
            currentIdx--;
        }

        sb.append("<");
        for (int i = 0; i < answer.length ; i++) {
            sb.append(answer[i]);
            if (i != answer.length - 1) {
                sb.append(", ");
            }

        }
        sb.append(">");

        System.out.println(sb);
    }
}
