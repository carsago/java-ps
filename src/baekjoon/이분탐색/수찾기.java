package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920 수 찾기, https://www.acmicpc.net/problem/1920
 */
public class 수찾기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        final int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        final int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] checkValues = new int[M];

        for (int i = 0; i < M; i++) {
            checkValues[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);


        for (int checkValue : checkValues) {
            if (contain(A, checkValue)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static boolean contain(final int[] checkValues, final int a) {
        int low = 0;
        int high = checkValues.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (a > checkValues[mid]) {
                low = mid + 1;
            } else if (a < checkValues[mid]){
                high = mid - 1;
            }

            else {
                return true;
            }
        }

        return false;
    }
}
