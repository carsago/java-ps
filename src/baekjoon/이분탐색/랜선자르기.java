package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long[] lans = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            int value = Integer.parseInt(br.readLine());
            lans[i] = value;

            if (max < value) {
                max =  value;
            }
        }

        long min = 0;
        long mid;

        while (min < max) {

            mid = (min + max) / 2;

            int count = getCount(mid, lans);
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }


    private static int getCount(long max, long[] lans) {
        int count = 0;
        for (long lan : lans) {
            count += lan / max;
        }
        return count;
    }
}
