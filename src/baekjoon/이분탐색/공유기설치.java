package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        final int countOfHouse = Integer.parseInt(st.nextToken());
        final int countOfLan = Integer.parseInt(st.nextToken());

        int[] values = new int[countOfHouse];

        for (int i = 0; i < countOfHouse; i++) {
            values[i] = Integer.parseInt( br.readLine());
        }

        // 1 2 4 6 9 15 18 20 23
        Arrays.sort(values);
    }
}
