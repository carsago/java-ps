package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/2217
 */
public class 로프 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            values.add(Integer.parseInt(br.readLine()));
        }
        values.sort(Comparator.naturalOrder());
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            answers.add(values.get(i) * (values.size() - i));
        }

        System.out.println(answers.stream()
                .max(Comparator.naturalOrder())
                .get());
    }
}
