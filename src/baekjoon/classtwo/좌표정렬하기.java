package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/11650
 */
public class 좌표정렬하기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);

            if (map.containsKey(x)) {
                List<Integer> list = map.get(x);
                list.add(y);
                continue;
            }

            List<Integer> list = new ArrayList<>();
            list.add(y);
            map.put(x, list);
        }

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (Integer value : list) {
                sb.append(key + " " + value + "\n");
            }
        }
        System.out.println(sb);
    }
}
