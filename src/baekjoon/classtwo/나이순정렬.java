package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10814
 */
public class 나이순정렬 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, List<String>> values = new HashMap<>();

        for (int i = 0; i < round; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            if (values.containsKey(age)) {
                List<String> list = values.get(age);
                list.add(st.nextToken());
                values.put(age, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(st.nextToken());
                values.put(age, list);
            }
        }

        for (int i = 1; i <= 200; i++) {
            if (values.containsKey(i)) {
                for (String value : values.get(i)) {
                    System.out.println(i + " " + value);
                }
            }
        }
    }
}
