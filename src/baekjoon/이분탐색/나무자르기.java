package baekjoon.이분탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2805, https://www.acmicpc.net/problem/2805
 */
public class 나무자르기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int max = 0;

        long[] values = new long[(int) N];
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(st.nextToken());
            values[i] = value;
            if (max < value) {
                max = (int) value;
            }
        }

        int min = 0;
        int mid;

        max++;

        while (min < max) {
            mid = (min + max) / 2;
            long length = getLength(mid, values);

            if (length < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max-1);
    }

    private static long getLength(int mid, long[] values) {
        long length = 0;
        for (long value : values) {
            if (value > mid) {
                length += value - mid;
            }
        }

        return length;
    }
}
