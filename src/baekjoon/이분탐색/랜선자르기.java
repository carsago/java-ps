package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1654, 랜선 자르기 https://www.acmicpc.net/problem/1654
 */
public class 랜선자르기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int countOfLine = Integer.parseInt(st.nextToken());
        int countOfGoal = Integer.parseInt(st.nextToken());

        long[] lines = new long[countOfLine];

        long maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < countOfLine; i++) {
            final long value = Integer.parseInt(br.readLine());
            lines[i] = value;
            if (maxValue < value) {
                maxValue = value;
            }
        }

        long minValue = 0;

        while (minValue <= maxValue) {
            long midValue = (minValue + maxValue) / 2;
            long count = getCount(lines, midValue);

            if (count < countOfGoal) {
                maxValue = midValue - 1;
            } else {
                minValue = midValue + 1;
            }
        }

        System.out.println((maxValue + minValue) / 2);
    }

    private static long getCount(final long[] lines, final long value) {
        long count = 0;

        for (long line : lines) {
            count += line / value;
        }
        return count;
    }
}
