package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2, https://www.acmicpc.net/problem/10816
 * 이분탐색아닌 HashMap으로 품
 */
public class 숫자카드2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(st.nextToken());

            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        long[] checkValues = new long[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            checkValues[i] = Long.parseLong(st.nextToken());
        }

        for (long checkValue : checkValues) {
            if (map.containsKey(checkValue)) {
                bw.write(map.get(checkValue) + " ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
    }
}
