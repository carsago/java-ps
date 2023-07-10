package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10773
 */
public class 제로 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < round; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                values.remove(values.size() - 1);
            } else {
                values.add(value);
            }
        }

        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }

        System.out.println(sum);
    }
}
