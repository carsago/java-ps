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

        final int countOfWood = Integer.parseInt(st.nextToken());
        final int goalHeight = Integer.parseInt(st.nextToken());

        int[] woods = new int[countOfWood];
        long maxValue = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countOfWood; i++) {
            final int value = Integer.parseInt(st.nextToken());
            woods[i] = value;
            if (maxValue < value) {
                maxValue = value;
            }
        }

        long minValue = 0;

        while (minValue <= maxValue) {
            long midValue = (maxValue + minValue) / 2;
            int height = 0;
            for (int wood : woods) {
                if (wood > midValue) {
                    height += wood - midValue;
                }
            }

            if (height >= goalHeight) {
                minValue = midValue + 1;
            } else {
                maxValue = midValue - 1;
            }
        }

        System.out.println((maxValue + minValue) / 2);
    }
}
