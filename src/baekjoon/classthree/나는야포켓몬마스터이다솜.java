package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/1620
 */
public class 나는야포켓몬마스터이다솜 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(br.readLine(), i);
        }
        Object[] array = map.keySet().toArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < M; i++) {
            String value = br.readLine();
            try {
                int number = Integer.parseInt(value);
                sb.append(array[number - 1] + "\n");

            } catch (NumberFormatException e) {
                sb.append(map.get(value) + "\n");
            }
        }

        System.out.println(sb);
    }
}
