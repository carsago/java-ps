package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2805
 */
public class 나무자르기 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static List<Integer> values = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] q = br.readLine().split(" ");
        n = Integer.parseInt(q[0]);
        m = Integer.parseInt(q[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values.add(Integer.parseInt(st.nextToken()));
        }

        int low = 0;
        int high = Collections.max(values);

        while (low <= high) {

            int mid = (low + high) / 2;
            int size = getTreeSize(mid);
            if (size >= m) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        System.out.println("high = " + high);
        System.out.println("low = " + low);
    }

    private static int getTreeSize(int standard) {
        int size = 0;
        for (Integer value : values) {
            if (value > size) {
                size += value - standard;
            }
        }
        return size;
    }
}
