package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/11651
 */
public class 좌표정렬하기2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);

            if (map.containsKey(y)) {
                List<Integer> list = map.get(y);
                list.add(x);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(x);
                map.put(y, list);
            }
        }

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (Integer value : list) {
                sb.append(value + " " + key + "\n");
            }
        }
        System.out.println(sb);
    }
}
