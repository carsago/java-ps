package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2609
 */
public class 최대공약수와최소공배수 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int first = 0;

        for (int i = 1; i <= Math.min(a,b); i++) {
            if (a % i == 0 && b % i == 0) {
                first = i;
            }
        }


        int a2 = a;
        int b2 = b;
        while (true) {
            if (a2 > b2) {
                b2 += b;
            } else if (a2 < b2) {
                a2 += a;
            } else {
                break;
            }
        }


        System.out.println(first);
        System.out.println(a2);
    }
}
