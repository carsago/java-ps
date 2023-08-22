package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/1764
 */
public class 듣보잡 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Map<String, Boolean> maps = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            maps.put(br.readLine(), false);
        }

        for (int i = 0; i < M; i++) {
            String value = br.readLine();
            if (maps.containsKey(value)) {
                maps.put(value, true);
            }
        }

        StringBuffer sb = new StringBuffer();
        int size = 0;
        for (String key : maps.keySet()) {
            if (maps.get(key)) {
                size++;
                sb.append(key + "\n");
            }
        }
        System.out.println(size);
        System.out.println(sb);
    }
}
