package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/18111
 */
public class 마인크래프트 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + 1);
                } else {
                    map.put(value, 1);
                }
            }
        }

        int maxAnswer = 0;
        int minAnswer = Integer.MAX_VALUE;
        /**
         *
         */

        for (int i = 0; i <= 256; i++) {
            int answer = 0;
            int countOfUse = 0;
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() > i) {
                    int gap = entry.getKey() - i;
                    answer += gap * 2 * entry.getValue();
                    countOfUse -= gap * entry.getValue();
                } else {
                    answer += (i - entry.getKey()) * entry.getValue();
                    countOfUse += (i - entry.getKey()) * entry.getValue();
                }
            }

            if (answer <= minAnswer && countOfUse <= bag) {
                maxAnswer = i;
                minAnswer = answer;
            }

        }

        System.out.println(minAnswer + " " + maxAnswer);
    }
}
